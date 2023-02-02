import org.junit.jupiter.api.Test;

public class ConsumerTest {

    @Test
    public void consumer1Test() {
        ReservationConsumer reservationConsumer = new ReservationConsumer();
        reservationConsumer.consume();
    }

    @Test
    public void consumer2Test() {
        ReservationConsumer reservationConsumer = new ReservationConsumer();
        reservationConsumer.consume();
    }
}
