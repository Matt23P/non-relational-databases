import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.Parent;
import repositories.ParentRepository;
import managers.ParentManager;


public class ParentTest {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BABYSITTER");
    private static final ParentRepository parentRepository = new ParentRepository();

    Parent parent = new Parent("Mateusz Przybyl", "Lodz Politechniki 1", 2137420L, "602783554");
    Parent parent1 = new Parent("Macij Przybylski", "Lodz Nowa 15 ", 7137540L, "307783554");

    @Test
    void parentAddTest(){
        ParentManager parentManager = new ParentManager(parentRepository);

        assertNotNull(parentRepository.add(parent));
        assertNull(parentRepository.add(parent));
        assertNotNull(parentManager.add("Wojciech", "Stefaniak", 6999760L, "504728952"));

    }


    @Test
    void parentRemoveTest(){
        ParentManager parentManager = new ParentManager(parentRepository);

        assertNotNull(parentRepository.add(parent));
        assertNotNull(parentRepository.add(parent1));

        assertTrue(parentManager.remove(parent));
        assertTrue(parentRepository.remove(parent1));
    }
}
