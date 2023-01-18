import com.datastax.oss.driver.api.core.CqlSession;
import managers.SitterDBManager;
import model.Parent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import repositories.ParentRepository;

public class ParentRepositoryTest {

    private static CqlSession cqlSession = SitterDBManager.initSession();
    private ParentRepository parentRepository = new ParentRepository(cqlSession);
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
}