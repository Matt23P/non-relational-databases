import managers.ParentManager;
import model.Parent;
import org.junit.Test;
import repositories.ParentRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ParentTest {

    private static final ParentRepository parentRepository = new ParentRepository();
    private ParentManager parentManager = new ParentManager(parentRepository);

    @Test
    public void parentAddTest(){
        long collectionSize = parentManager.getSize();
        assertTrue(parentManager.add("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8));
        assertEquals(collectionSize+1, parentManager.getSize());
        assertTrue(parentManager.add("Wojciech Stefanowski", "Lodz Politechniki1", "211566677", 5));
        assertEquals(collectionSize+2, parentManager.getSize());
    }

    @Test
    public void parentGetTest(){
        Parent parent = new Parent("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8);
        assertNotNull(parentRepository.add(parent));

        assertEquals(parent.getEntityId().getUuid(), parentRepository.get(parent).getEntityId().getUuid());
        assertEquals(parent.getName(), parentRepository.get(parent).getName());
        assertEquals(parent.getAddress(), parentRepository.get(parent).getAddress());
        assertEquals(parent.getPhoneNumber(), parentRepository.get(parent).getPhoneNumber());
        assertEquals(parent.getChildAge(), parentRepository.get(parent).getChildAge());
    }

    @Test
    public void parentUpdateTest(){
        Parent parent = new Parent("Wojciech Stefanowski", "Lodz Politechniki1", "211566677", 5);
        assertNotNull(parentRepository.add(parent));

        parent.setName("Joe Zaza");
        parent.setAddress("Pabianice Dluga13");
        parent.setPhoneNumber("123456789");
        parent.setChildAge(10);

        assertEquals("Joe Zaza", parent.getName());
        assertEquals("Pabianice Dluga13", parent.getAddress());
        assertEquals("123456789", parent.getPhoneNumber());
        assertEquals(10, parent.getChildAge());

        parentRepository.update(parent);

        Parent parent_updated = parentRepository.getByEntityId(parent.getEntityId());

        assertEquals(parent.getName(), parent_updated.getName());
        assertEquals(parent.getAddress(), parent_updated.getAddress());
        assertEquals(parent.getPhoneNumber(), parent_updated.getPhoneNumber());
        assertEquals(parent.getChildAge(), parent_updated.getChildAge());
    }

    @Test
    public void parentRemoveTest(){
        Parent parent_1 = new Parent("Wojciech Stefanowski", "Lodz Politechniki1", "211566677", 5);
        Parent parent_2 = new Parent("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8);

        assertNotNull(parentRepository.add(parent_1));
        assertNotNull(parentRepository.add(parent_2));

        long collectionSize = parentManager.getSize();

        parentManager.remove(parent_1);
        assertEquals(collectionSize-1, parentManager.getSize());
        parentManager.remove(parent_2);
        assertEquals(collectionSize-2, parentManager.getSize());
    }
}