import com.datastax.oss.driver.api.core.CqlSession;
import managers.SitterDBManager;
import model.Sitter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import repositories.SitterRepository;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class SitterRepositoryTest {
    private static final CqlSession cqlSession = SitterDBManager.initSession();
    private final SitterRepository sitterRepository = new SitterRepository(cqlSession);
    private Sitter sitter1;
    private Sitter sitter2;

    @Test
    public void AddGetTest() {
        sitter1 = new Sitter("1", "Krystyna", "Mazur", "cleaning", 10);
        sitter2 = new Sitter("2", "Michael", "Jackson", "singing", 7);

        sitterRepository.add(sitter1);
        sitterRepository.add(sitter2);

        assertEquals(sitter1.getSitter_id(), sitterRepository.get(sitter1.getSitter_id()).getSitter_id());
        assertEquals(sitter2.getSitter_id(), sitterRepository.get(sitter2.getSitter_id()).getSitter_id());
    }

    @Test
    public void DeleteTest() {
        sitter1 = new Sitter("3", "John", "Smith", "jumping", 11);

        sitterRepository.add(sitter1);
        sitterRepository.remove(sitter1);
        assertThrows(NoSuchElementException.class, () -> sitterRepository.get(sitter1.getSitter_id()));
    }

    @Test
    public void UpdateTest() {
        sitter1 = new Sitter("4", "Mateusz", "Przybylski", "cooking", 8);
        sitterRepository.add(sitter1);
        Sitter forUpdate = sitter1;
        forUpdate.setFirstName("Wojciech");
        sitterRepository.update(forUpdate);
        assertEquals(forUpdate.getSitter_id(), sitterRepository.get(forUpdate.getSitter_id()).getSitter_id());
        assertEquals(forUpdate.getFirstName(), sitterRepository.get(forUpdate.getSitter_id()).getFirstName());
        assertEquals(forUpdate.getLastName(), sitterRepository.get(forUpdate.getSitter_id()).getLastName());
        assertEquals(forUpdate.getSkill(), sitterRepository.get(forUpdate.getSitter_id()).getSkill());
        assertEquals(forUpdate.getMinAge(), sitterRepository.get(forUpdate.getSitter_id()).getMinAge());
    }

    @AfterAll
    public static void closeSession() {
        cqlSession.close();
    }
}