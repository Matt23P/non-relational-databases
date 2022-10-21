import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

import model.Sitter;
import managers.SitterManager;
import repositories.ReservationRepository;
import repositories.SitterRepository;
import model.Housekeeper;
import model.Academic;

public class SitterTest {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BABYSITTER");
    private static final SitterRepository sitterRepository = new SitterRepository();

    Sitter sitter = new Sitter("Agnieszka", "Bach", 50.0);
    Academic sitter_aca = new Academic("Genowefa", "Martyniuk", 25.0, "Chemistry", 23, 30.0);
    Housekeeper sitter_hou = new Housekeeper("Adam", "Mekeke", 30.0, "Dish washing");

    @Test
    public void SitterAddTest() {
        SitterManager manager = new SitterManager(sitterRepository);
        assertNotNull(sitterRepository.add(sitter_aca));
        assertNotNull(manager.add("Agnieszka", "Bach", 50.0)); //przez SitterManager mozna dodac tylko obiekt typu sitter
        assertNotNull(sitterRepository.add(sitter_hou));
    }

    @Test
    public void SitterRemoveTest() {
        SitterManager manager = new SitterManager(sitterRepository);

        assertNotNull(sitterRepository.add(sitter));
        assertNotNull(sitterRepository.add(sitter_aca));

        assertTrue(sitterRepository.remove(sitter));
        assertTrue(sitterRepository.remove(sitter_aca));
    }
}
