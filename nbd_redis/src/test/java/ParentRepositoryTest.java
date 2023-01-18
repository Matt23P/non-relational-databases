import com.datastax.oss.driver.api.core.CqlSession;
import managers.SitterDBManager;
import model.Parent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import repositories.ParentRepository;
import java.util.NoSuchElementException;

public class ParentRepositoryTest {

    private static final CqlSession cqlSession = SitterDBManager.initSession();
    private final ParentRepository parentRepository = new ParentRepository(cqlSession);
    private Parent parent1;
    private Parent parent2;

    @Test
    public void AddGetTest() {
        parent1 = new Parent("1", "Krystyna Kaczor", "Radom ul.Nowa 1", "605286822", 10);
        parent2 = new Parent("2", "Tomasz Kaczka", "Pcim ul.Stara 2", "625402687", 7);

        parentRepository.add(parent1);
        parentRepository.add(parent2);

        assertEquals(parent1, parentRepository.get(parent1.getParent_id()));
        assertEquals(parent2, parentRepository.get(parent2.getParent_id()));
    }

    @Test
    public void DeleteTest() {
        parent1 = new Parent("3", "Mariusz Nowak", "Radmon ul.Nawo 11", "605277722", 11);

        parentRepository.add(parent1);
        parentRepository.remove(parent1);
        assertThrows(NoSuchElementException.class, () -> parentRepository.get(parent1.getParent_id()));
    }

    @Test
    public void UpdateTest() {
        parent1 = new Parent("4", "Mateusz Przybylski", "Paryrz ul.Politechniki 11", "727277722", 8);
        parentRepository.add(parent1);
        Parent forUpdate = parent1;
        forUpdate.setName("Wojciech Stefanowski");
        parentRepository.update(forUpdate);
        assertEquals(forUpdate, parentRepository.get(forUpdate.getParent_id()));
    }

    @AfterAll
    public static void closeSession() {
        cqlSession.close();
    }
}