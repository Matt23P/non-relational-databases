package repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.UniqueId;
import model.Reservation;
import redis.clients.jedis.*;
import redis.clients.jedis.json.Path;


public class ReservationCacheRepository extends ReservationRepository {
    private JedisPooled pool;
    private Jedis jedis;
    private Gson gson;
    private long lastCheck;
    private boolean connected;

    public ReservationCacheRepository() {
        try {
            gson = new GsonBuilder().create();
            JedisClientConfig clientConfig = DefaultJedisClientConfig.builder().socketTimeoutMillis(100).build();
            jedis = new Jedis(new HostAndPort("localhost",6379),clientConfig);
            pool.set("ping","ping");
            connected = true;
        } catch (Exception exception) {
            connected = false;
        }
    }

    private boolean healthCheck() {
        if (System.currentTimeMillis() - lastCheck < 60000) {return false;}
        try { pool.set("ping","ping"); }
        catch (Exception exception) { return false; }
        if(!connected) {
            jedis.flushDB();
            connected = true;
        }
        return true;
    }

    private void jedisConnectionExceptionHandler(Exception exception){
        exception.printStackTrace();
        connected = false;
        lastCheck = System.currentTimeMillis();
    }

    private void addToCache(Reservation reservation){
        pool.jsonSet("reservations:" + reservation, gson.toJson(reservation));
        pool.expire("reservations:" + reservation, 60);
    }

    @Override
    public Reservation add(Reservation reservation) {
        Reservation reservation1 = super.add(reservation);
        if(connected){
            try {
                addToCache(reservation);
            }
            catch (Exception exception){
                jedisConnectionExceptionHandler(exception);
            }
        }
        else {
            if(healthCheck()){
                add(reservation);
            }
        }
        return reservation1;
    }

    @Override
    public void remove(Reservation reservation) {
        if(connected){
            try{
                pool.jsonDel("reservations:" + reservation.getEntityId().getUuid());
            }
            catch (Exception exception){
                jedisConnectionExceptionHandler(exception);
                remove(reservation);
            }
        }
        else {
            if(healthCheck()){
                remove(reservation);
            }
        }
        super.remove(reservation);
    }

    @Override
    public Reservation getByEntityId(UniqueId uniqueId) {
        if(connected){
            Reservation reservation = null;
            try{
                String json = pool.jsonGetAsPlainString("reservations:" + uniqueId.getUuid(), Path.ROOT_PATH);
                reservation = gson.fromJson(json, Reservation.class);
            }
            catch (Exception exception){
                jedisConnectionExceptionHandler(exception);
                getByEntityId(uniqueId);
            }
            if(reservation != null){
                System.out.println("Reservation from cache");
                return reservation;
            }
            else {
                Reservation reservation1 = super.getByEntityId(uniqueId);
                try{
                    if(reservation1 != null){
                        addToCache(reservation1);
                    }
                }
                catch (Exception exception){
                    jedisConnectionExceptionHandler(exception);
                }
                return reservation1;
            }
        }
        else {
            if(healthCheck()){
                getByEntityId(uniqueId);
            }
        }
        return super.getByEntityId(uniqueId);
    }

    @Override
    public boolean update(Reservation reservation) {
        boolean updated = super.update(reservation);
        if(connected && updated){
            try{
                pool.jsonSet("reservations:" + reservation.getEntityId().getUuid(), gson.toJson(reservation));
            }
            catch (Exception exception){
                jedisConnectionExceptionHandler(exception);
                update(reservation);
            }
        } else if (!connected && updated) {
            if(healthCheck()){
                update(reservation);
            }
        }
        return updated;
    }

    @Override
    public Reservation get(Reservation item) {
        if(connected) {
            Reservation reservation = null;
            try{
                String json = pool.jsonGetAsPlainString("reservations:" + item, Path.ROOT_PATH);
                reservation = gson.fromJson(json, Reservation.class);
            }
            catch (Exception exception){
                jedisConnectionExceptionHandler(exception);
                get(item);
            }
            if(reservation != null){
                System.out.println("Reservation from cache");
                return reservation;
            }
            else {
                Reservation reservation1 = super.get(item);
                try{
                    if(reservation1 != null){
                        addToCache(reservation1);
                    }
                }
                catch (Exception exception) {
                    jedisConnectionExceptionHandler(exception);
                }
                return reservation1;
            }
        }
        else {
            if(healthCheck()) {
                get(item);
            }
        }
        return super.get(item);
    }
}
