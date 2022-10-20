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

    Parent parent = new Parent("Mateusz Przybyl", "Lodz Politechniki 1", "602783554");
    Parent parent1 = new Parent("Macij Przybylski", "Lodz Nowa 15 ", "307783554");

    @Test
    void parentAddTest(){
        ParentManager parentManager = new ParentManager(parentRepository);

        assertNotNull(parentRepository.add(parent));
        assertNull(parentRepository.add(parent));  //TUTAJ innaczej testowac, merge() tak jak w remove,
                                                    //proba dodania z tymi samymi dabymi ale inny obiekt
        assertNotNull(parentManager.add("Wojciech", "Stefaniak", "504728952"));

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
