package repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.UniqueId;
import model.Reservation;
import redis.clients.jedis.*;

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

//    private void addToCache(Reservation reservation) {
//        pool.jsonSet("Reservation:" + reservation.getReservation???XDDDKurwachujpierdole)
//    }

    @Override
    public Reservation add(Reservation reservation) {
        Reservation reservation1 = super.add(reservation)
    }

    @Override
    public void remove(Reservation reservation) {

    }

    @Override
    public Reservation getByUniqueId(UniqueId uniqueId) {

    }

    @Override
    public boolean update(Reservation reservation) {

    }

    @Override
    public Reservation getByReservation(Long number) {

    }

}
