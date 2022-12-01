import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import managers.ReservationManager;
import model.Parent;
import model.Reservation;
import model.Sitter;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPooled;
import repositories.ReservationCacheRepository;

import java.time.LocalDate;
import java.time.LocalTime;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedisTest {

    protected DefaultJedisClientConfig jedisClientConfig = DefaultJedisClientConfig.builder().build();
    protected JedisPooled RedisClient;
    protected Jsonb jsonb;

    private static final ReservationCacheRepository reservationCacheRepository = new ReservationCacheRepository();

    private static final ReservationManager reservationCacheManager = new ReservationManager(reservationCacheRepository);


    @Test
    public void redisTest() {
        this.jedisClientConfig = DefaultJedisClientConfig.builder().build();
        this.RedisClient = new JedisPooled(new HostAndPort("localhost", 6379), jedisClientConfig);
        this.jsonb = JsonbBuilder.create();

        Parent parent = new Parent("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8);
        Sitter sitter = new Sitter("Katarzyna", "Nowak", Sitter.SitterType.HOUSEKEEPER, 110, "Cooking", 7, true);
        Reservation reservation = new Reservation(LocalDate.of(2022, 12, 12), LocalTime.of(9, 0), LocalTime.of(20, 0), parent, sitter);
        assertTrue(reservationCacheManager.add(reservation));

        assertEquals(reservationCacheManager.get(reservation.getEntityId()).getEntityId().getUuid(), reservation.getEntityId().getUuid());
        assertEquals(reservationCacheManager.get(reservation.getEntityId()).getDate(), reservation.getDate());
        assertEquals(reservationCacheManager.get(reservation.getEntityId()).getSitter().getEntityId().getUuid(), reservation.getSitter().getEntityId().getUuid());
        assertEquals(reservationCacheManager.get(reservation.getEntityId()).getParent().getEntityId().getUuid(), reservation.getParent().getEntityId().getUuid());
        assertEquals(reservationCacheManager.get(reservation.getEntityId()).getStartTime(), reservation.getStartTime());
        assertEquals(reservationCacheManager.get(reservation.getEntityId()).getEndTime(), reservation.getEndTime());

    }

}
