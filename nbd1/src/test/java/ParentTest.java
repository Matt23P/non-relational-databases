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

    Parent parent = new Parent("Mateusz Przybyl", "Lodz Politechniki 1", "602783554");
    Parent parent1 = new Parent("Macij Przybylski", "Lodz Nowa 15 ", "307783554");

    Parent parent2 = new Parent("Test Testowy", "Testowa 13 ", "111222333");
    Parent parent2a = new Parent("Test Testowy", "Testowa 13 ", "111222333");

    @Test
    void parentAddTest() {
        ParentManager parentManager = new ParentManager(parentRepository);

        assertNotNull(parentRepository.add(parent));
        assertNotNull(parentRepository.add(parent1));
        //assertNull(parentRepository.add(parent)); //TUTAJ innaczej testowac, merge() tak jak w remove,

        //proba dodania z tymi samymi danymi poprzez manager
        assertNotNull(parentManager.add("Wojciech", "Stefaniak", "504728952"));
        assertNotNull(parentManager.add("Wojciech", "Stefaniak", "504728952"));
        //proba dodania z tymi samymi danymi poprzez repository (dwa rozne obiekty - te same dane)
        assertNotNull(parentRepository.add(parent2));
        assertNotNull(parentRepository.add(parent2a));

    }


    @Test
    void parentRemoveTest() {
        ParentManager parentManager = new ParentManager(parentRepository);

        assertNotNull(parentRepository.add(parent));
        assertNotNull(parentRepository.add(parent1));

        assertTrue(parentManager.remove(parent));
        assertTrue(parentRepository.remove(parent1));
    }
}
