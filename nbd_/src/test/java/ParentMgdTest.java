import managers.ParentManagerMgd;
import model.ParentMgd;
import org.junit.Test;
import repositories.ParentRepositoryMgd;

import static org.junit.jupiter.api.Assertions.*;

public class ParentMgdTest {

    private static final ParentRepositoryMgd parentRepositoryMgd = new ParentRepositoryMgd();
    private ParentManagerMgd parentManagerMgd = new ParentManagerMgd(parentRepositoryMgd);

    @Test
    public void parentAddTest(){
        long collectionSize = parentManagerMgd.getSize();
        assertTrue(parentManagerMgd.add("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8));
        assertEquals(collectionSize+1, parentManagerMgd.getSize());
        assertTrue(parentManagerMgd.add("Wojciech Stefanowski", "Lodz Politechniki1", "211566677", 5));
        assertEquals(collectionSize+2, parentManagerMgd.getSize());
    }

    @Test
    public void parentGetTest(){
        ParentMgd parentMgd = new ParentMgd("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8);
        assertNotNull(parentRepositoryMgd.add(parentMgd));

        assertEquals(parentMgd, parentRepositoryMgd.get(parentMgd));
        assertEquals(parentMgd.getEntityId().getUuid(), parentRepositoryMgd.get(parentMgd).getEntityId().getUuid());
        assertEquals(parentMgd.getName(), parentRepositoryMgd.get(parentMgd).getName());
        assertEquals(parentMgd.getAddress(), parentRepositoryMgd.get(parentMgd).getAddress());
        assertEquals(parentMgd.getPhoneNumber(), parentRepositoryMgd.get(parentMgd).getPhoneNumber());
        assertEquals(parentMgd.getChildAge(), parentRepositoryMgd.get(parentMgd).getChildAge());
    }

    @Test
    public void parentUpdateTest(){
        ParentMgd parentMgd = new ParentMgd("Wojciech Stefanowski", "Lodz Politechniki1", "211566677", 5);
        assertNotNull(parentRepositoryMgd.add(parentMgd));

        parentMgd.setName("Joe Zaza");
        parentMgd.setAddress("Pabianice Dluga13");
        parentMgd.setPhoneNumber("123456789");
        parentMgd.setChildAge(10);

        assertEquals("Joe Zaza", parentMgd.getName());
        assertEquals("Pabianice Dluga13", parentMgd.getAddress());
        assertEquals("123456789", parentMgd.getPhoneNumber());
        assertEquals(10, parentMgd.getChildAge());

        parentRepositoryMgd.update(parentMgd);

        ParentMgd parentMgd_updated = parentRepositoryMgd.getByEntityId(parentMgd.getEntityId());

        assertEquals(parentMgd.getName(), parentMgd_updated.getName());
        assertEquals(parentMgd.getAddress(), parentMgd_updated.getAddress());
        assertEquals(parentMgd.getPhoneNumber(), parentMgd_updated.getPhoneNumber());
        assertEquals(parentMgd.getChildAge(), parentMgd_updated.getChildAge());
    }

    @Test
    public void parentRemoveTest(){
        ParentMgd parentMgd_1 = new ParentMgd("Wojciech Stefanowski", "Lodz Politechniki1", "211566677", 5);
        ParentMgd parentMgd_2 = new ParentMgd("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8);

        assertNotNull(parentRepositoryMgd.add(parentMgd_1));
        assertNotNull(parentRepositoryMgd.add(parentMgd_2));

        long collectionSize = parentManagerMgd.getSize();

        parentManagerMgd.remove(parentMgd_1);
        assertEquals(collectionSize-1, parentManagerMgd.getSize());
        parentManagerMgd.remove(parentMgd_2);
        assertEquals(collectionSize-2, parentManagerMgd.getSize());
    }
}
