import managers.ReservationManager;
import model.Parent;
import model.Reservation;
import model.Sitter;
import org.junit.jupiter.api.Test;
import repositories.ParentRepository;
import repositories.ReservationRepository;
import repositories.SitterRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {
    private static final ReservationRepository reservationRepository = new ReservationRepository();
    private static final ParentRepository parentRepositiry = new ParentRepository();
    private static final SitterRepository sitterRepository = new SitterRepository();
    private static final ReservationManager reservationManager = new ReservationManager(reservationRepository);

    @Test
    public void addTest() {
        Parent parent = new Parent("Maria Kowal", "Kostrzyn ul.Stara 1", "654987321", 9);
        Sitter sitter = new Sitter("Mariusz", "Busz", Sitter.SitterType.ACADEMIC, 30, "Matematyka", 8, true);
        Reservation reservation = new Reservation(LocalDate.of(2023, 3,10),
                LocalTime.of(10, 10), LocalTime.of(20, 20), parent, sitter);
        assertNotNull(parentRepositiry.add(parent));
        assertNotNull(sitterRepository.add(sitter));

        long reservationReposirotySize = reservationRepository.getCollectionSize();
        assertNotNull(reservationRepository.add(reservation));
        assertEquals(reservationReposirotySize + 1, reservationRepository.getCollectionSize());
        assertTrue(reservationManager.add(LocalDate.of(2023, 3, 11),
                LocalTime.of(10, 30), LocalTime.of(20, 20), parent, sitter));
        assertEquals(reservationReposirotySize + 2, reservationRepository.getCollectionSize());
    }

    @Test
    public void getTest() {
        Parent parent = new Parent("Maria Kowal", "Kostrzyn ul.Stara 1", "654987321", 9);
        Sitter sitter = new Sitter("Mariusz", "Busz", Sitter.SitterType.ACADEMIC, 30, "Matematyka", 8, true);
        Reservation reservation = new Reservation(LocalDate.of(2023, 3,10),
                LocalTime.of(10, 10), LocalTime.of(20, 20), parent, sitter);
        assertNotNull(parentRepositiry.add(parent));
        assertNotNull(sitterRepository.add(sitter));
        assertNotNull(reservationRepository.add(reservation));
        assertEquals(reservation.getEntityId().getUuid(),
                reservationRepository.getByEntityId(reservation.getEntityId()).getEntityId().getUuid());
    }

    @Test
    public void removeTest() {
        Parent parent = new Parent("Maria Kowal", "Kostrzyn ul.Stara 1", "654987321", 9);
        Sitter sitter = new Sitter("Mariusz", "Busz", Sitter.SitterType.ACADEMIC, 30, "Matematyka", 8, true);
        Reservation reservation1 = new Reservation(LocalDate.of(2023, 3,10),
                LocalTime.of(10, 10), LocalTime.of(20, 20), parent, sitter);
        Reservation reservation2 = new Reservation(LocalDate.of(2023, 3,11),
                LocalTime.of(10, 10), LocalTime.of(20, 20), parent, sitter);
        assertNotNull(parentRepositiry.add(parent));
        assertNotNull(sitterRepository.add(sitter));
        assertNotNull(reservationRepository.add(reservation1));
        assertNotNull(reservationRepository.add(reservation2));

        long reservationRepositorySize = reservationRepository.getCollectionSize();
        reservationRepository.remove(reservation1);
        assertEquals(reservationRepositorySize - 1, reservationRepository.getCollectionSize());
        reservationManager.remove(reservation2);
        assertEquals(reservationRepositorySize - 2, reservationRepository.getCollectionSize());
    }

    @Test
    public void updateTest() {
        Parent parent1 = new Parent("Maria Kowal", "Kostrzyn ul.Stara 1", "654987321", 9);
        Parent parent2 = new Parent("Grzegorz Kowal", "Opoczno ul.Stara 1", "444987321", 9);
        Sitter sitter1 = new Sitter("Mariusz", "Busz", Sitter.SitterType.ACADEMIC, 30, "Matematyka", 8, true);
        Sitter sitter2 = new Sitter("Maria", "Butla", Sitter.SitterType.ACADEMIC, 20, "Matematyka", 8, true);

        Reservation reservation = new Reservation(LocalDate.of(2023, 3,10),
                LocalTime.of(10, 10), LocalTime.of(20, 20), parent1, sitter1);
        assertNotNull(parentRepositiry.add(parent1));
        assertNotNull(parentRepositiry.add(parent2));
        assertNotNull(sitterRepository.add(sitter1));
        assertNotNull(sitterRepository.add(sitter2));
        assertNotNull(reservationRepository.add(reservation));

        reservation.setDate(LocalDate.of(2023, 3, 12));
        reservation.setParent(parent2);
        reservation.setSitter(sitter2);
        reservationRepository.update(reservation);

        Reservation updated = reservationRepository.getByEntityId(reservation.getEntityId());
        assertEquals(reservation.getDate(), updated.getDate());
        assertEquals(reservation.getParent().getEntityId().getUuid(), updated.getParent().getEntityId().getUuid());
        assertEquals(reservation.getSitter().getEntityId().getUuid(), updated.getSitter().getEntityId().getUuid());
    }
}
