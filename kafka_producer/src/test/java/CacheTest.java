import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import managers.ReservationManager;
import model.Parent;
import model.Reservation;
import model.Sitter;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPooled;
import repositories.ReservationCacheRepository;
import repositories.ReservationRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class CacheTest {
    private static final ReservationCacheRepository reservationCache = new ReservationCacheRepository();
    private static final ReservationManager reservationCacheManager = new ReservationManager(reservationCache);

    protected DefaultJedisClientConfig defaultJedisClientConfig = DefaultJedisClientConfig.builder().build();
    protected JedisPooled RedisClient;
    protected Jsonb jsonb;

    @Test
    public void redisCacheTest() {
        this.defaultJedisClientConfig = DefaultJedisClientConfig.builder().build();
        this.RedisClient = new JedisPooled(new HostAndPort("localhost", 6379), defaultJedisClientConfig);
        this.jsonb = JsonbBuilder.create();

        Parent parent = new Parent("Marek Mostowiak", "Opoczno ul.Jana 12", "123456789", 10);
        Sitter sitter = new Sitter("Anna", "Nowak", Sitter.SitterType.ACADEMIC, 30, "Matematyka", 7, true);
        Reservation reservation = new Reservation(LocalDate.of(2023, 3,10),
                LocalTime.of(10, 10), LocalTime.of(20, 20), parent, sitter);

        assertNotNull(reservationCache.add(reservation));
        assertTrue(reservationCacheManager.add(LocalDate.of(2024, 10,10),
                LocalTime.of(10, 10), LocalTime.of(20, 20), parent, sitter));
    }
}
