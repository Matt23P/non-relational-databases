import managers.ParentManager;
import model.Parent;
import org.junit.Test;
import repositories.ParentRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ParentTest {

    private static final ParentRepository parentRepository = new ParentRepository();
    private ParentManager parentManager = new ParentManager(parentRepository);

    @Test
    public void addTest() {
        Parent parent1 = new Parent("Marek Mostowiak", "Opoczno ul.Jana 12", "123456789", 10);
        Parent parent2 = new Parent("Mariusz Drogowiak", "Opoczno ul.Jacka 21", "888555222", 5);
        long parentRepositorySizeR = parentRepository.getCollectionSize();
        assertNotNull(parentRepository.add(parent1));
        assertEquals(parentRepositorySizeR + 1, parentRepository.getCollectionSize());
        assertNotNull(parentRepository.add(parent2));
        assertEquals(parentRepositorySizeR + 2, parentRepository.getCollectionSize());

        long parentRepositorySizeM = parentRepository.getCollectionSize();
        assertTrue(parentManager.add("Jacek Kot", "Grabina ul.Nowa 20", "987654321", 6));
        assertEquals(parentRepositorySizeM + 1, parentRepository.getCollectionSize());
        assertTrue(parentManager.add("Jan Pies", "Grabowo ul.Stara 2", "444555666", 8));
        assertEquals(parentRepositorySizeM + 2, parentRepository.getCollectionSize());
    }

    @Test
    public void getTest() {
        Parent parent = new Parent("Maria Kowal", "Kostrzyn ul.Stara 1", "654987321", 9);
        parentRepository.add(parent);
        assertEquals(parent.getEntityId().getUuid(), parentRepository.get(parent).getEntityId().getUuid());
    }

    @Test
    public void removeTest() {
        Parent parent1 = new Parent("Marek Mostowiak", "Opoczno ul.Jana 12", "123456789", 10);
        Parent parent2 = new Parent("Mariusz Drogowiak", "Opoczno ul.Jacka 21", "888555222", 5);
        assertNotNull(parentRepository.add(parent1));
        assertNotNull(parentRepository.add(parent2));
        long parentRepositorySize = parentRepository.getCollectionSize();
        parentRepository.remove(parent1);
        assertEquals(parentRepositorySize - 1, parentRepository.getCollectionSize());
        parentManager.remove(parent2);
        assertEquals(parentRepositorySize - 2, parentRepository.getCollectionSize());
    }

    @Test
    public void updateTest() {
        Parent parent = new Parent("Adam Nowak", "Opoczno ul.Jakuba 12", "222444888", 10);
        parentRepository.add(parent);
        parent.setName("Aleksander Wielki");
        parent.setAddress("Aleksandria ul.Aleksandra 1");
        parent.setPhoneNumber("333666999");
        parent.setChildAge(6);
        parentRepository.update(parent);
        Parent updated = parentRepository.getByEntityId(parent.getEntityId());

        assertEquals(parent.getName(), updated.getName());
        assertEquals(parent.getAddress(), updated.getAddress());
        assertEquals(parent.getPhoneNumber(), updated.getPhoneNumber());
        assertEquals(parent.getChildAge(), updated.getChildAge());
    }
}
