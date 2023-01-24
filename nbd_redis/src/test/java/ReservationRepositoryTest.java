import com.datastax.oss.driver.api.core.CqlSession;
import managers.SitterDBManager;
import model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import repositories.*;
import java.util.NoSuchElementException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationRepositoryTest {

    private static final CqlSession cqlSession = SitterDBManager.initSession();
    private final ParentRepository parentRepository = new ParentRepository(cqlSession);
    private final SitterRepository sitterRepository = new SitterRepository(cqlSession);
    private final ReservationRepository reservationRepository = new ReservationRepository(cqlSession);
    private Parent parent;
    private Sitter sitter;
    private Reservation reservation1;
    private Reservation reservation2;

    @Test
    public void AddGetTest() {
        parent = new Parent("1", "Krystyna Kaczor", "Radom ul.Nowa 1", "605286822", 10);
        sitter = new Sitter("1", "Krystyna", "Mazur", "cleaning", 10);
        parentRepository.add(parent);
        sitterRepository.add(sitter);

        reservation1 = new Reservation("1", parent.getParent_id(), sitter.getSitter_id(), LocalDate.of(2023, 2, 12), LocalTime.of(9, 0), LocalTime.of(20, 0));
        reservation2 = new Reservation("2", parent.getParent_id(), sitter.getSitter_id(), LocalDate.of(2023, 3, 22), LocalTime.of(10, 30), LocalTime.of(20, 0));

        reservationRepository.add(reservation1);
        reservationRepository.add(reservation2);

        assertEquals(reservation1.getReservation_id(), reservationRepository.get(reservation1.getReservation_id()).getReservation_id());
        assertEquals(reservation2.getReservation_id(), reservationRepository.get(reservation2.getReservation_id()).getReservation_id());
    }

    @Test
    public void DeleteTest() {
        parent = new Parent("2", "Tomasz Kaczka", "Pcim ul.Stara 2", "625402687", 7);
        sitter = new Sitter("2", "Michael", "Jackson", "singing", 7);
        reservation1 = new Reservation("3", parent.getParent_id(), sitter.getSitter_id(), LocalDate.of(2023, 2, 12), LocalTime.of(9, 0), LocalTime.of(20, 0));
        parentRepository.add(parent);
        sitterRepository.add(sitter);
        reservationRepository.add(reservation1);

        reservationRepository.deleteReservation(reservation1);

        assertThrows(NoSuchElementException.class, () -> reservationRepository.get(reservation1.getReservation_id()));
    }

    @Test
    public void UpdateTest() {
        parent = new Parent("3", "Mariusz Nowak", "Radmon ul.Nawo 11", "605277722", 11);
        sitter = new Sitter("3", "John", "Smith", "jumping", 11);
        reservation1 = new Reservation("3", parent.getParent_id(), sitter.getSitter_id(), LocalDate.of(2025, 7, 12), LocalTime.of(9, 0), LocalTime.of(20, 0));
        parentRepository.add(parent);
        sitterRepository.add(sitter);
        reservationRepository.add(reservation1);

        Reservation forUpdate = reservation1;
        forUpdate.setEndTime(LocalTime.of(18, 30));
        reservationRepository.update(forUpdate);
        assertEquals(forUpdate.getReservation_id(), reservationRepository.get(forUpdate.getReservation_id()).getReservation_id());
        assertEquals(forUpdate.getParent_id(), reservationRepository.get(forUpdate.getReservation_id()).getParent_id());
        assertEquals(forUpdate.getSitter_id(), reservationRepository.get(forUpdate.getReservation_id()).getSitter_id());
        assertEquals(forUpdate.getDate(), reservationRepository.get(forUpdate.getReservation_id()).getDate());
        assertEquals(forUpdate.getStartTime(), reservationRepository.get(forUpdate.getReservation_id()).getStartTime());
        assertEquals(forUpdate.getEndTime(), reservationRepository.get(forUpdate.getReservation_id()).getEndTime());

    }

    @AfterAll
    public static void closeSession() {
        cqlSession.close();
    }
}