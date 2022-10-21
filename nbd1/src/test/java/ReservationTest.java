import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.type.LocalDateType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

import model.Reservation;
import managers.ReservationManager;
import repositories.ReservationRepository;
import model.Sitter;
import model.Housekeeper;
import model.Academic;
import model.Parent;
import model.Reservation;

public class ReservationTest {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BABYSITTER");
    private static final ReservationRepository parentRepository = new ReservationRepository();

    Academic sitter1 = new Academic("Anna", "Nowak", 20.0, "Math", 18, 5.0);
    Housekeeper sitter2 = new Housekeeper("Mia", "Kerfus", 35.0, "Cleaning");

    Parent parent1 = new Parent("Wojciech Zaza", "Al. Politechniki 21/37", "133742096");
    Parent parent2 = new Parent("Jacek BMW", "Ul. Jana Matejki 12", "690247331");

    LocalDate date = LocalDate.of(2022, 5, 13);


    Reservation reservation1 = new Reservation(LocalDate.of(2023, 5, 13), LocalTime.of(13, 0), LocalTime.of(14, 0), sitter1, parent1);
    Reservation reservation2 = new Reservation(LocalDate.of(2022, 11, 20), LocalTime.of(8, 30), LocalTime.of(16, 30), sitter2, parent2);

    @Test
    void ReservationAddTest() {
        ReservationManager manager = new ReservationManager(parentRepository);
        assertNotNull(manager.add(LocalDate.of(2023, 2, 15), LocalTime.of(8, 0), LocalTime.of(14, 30), sitter1, parent2));
        assertNotNull(parentRepository.add(reservation1));
    }

    @Test
    void ReservationRemoveTest() {
        ReservationManager manager = new ReservationManager(parentRepository);
        assertNotNull(parentRepository.add(reservation1));
        assertNotNull(parentRepository.add(reservation2));

        assertTrue(parentRepository.remove(reservation1));
        assertFalse(parentRepository.remove(reservation1));
        assertTrue(manager.remove(reservation2));
    }

}
