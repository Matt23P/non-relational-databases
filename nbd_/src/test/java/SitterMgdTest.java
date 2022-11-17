import managers.SitterManagerMgd;
import model.SitterMgd;
import org.junit.Test;
import repositories.SitterRepositoryMgd;

import static org.junit.jupiter.api.Assertions.*;
public class SitterMgdTest {
    private static final SitterRepositoryMgd sitterRepositoryMgd = new SitterRepositoryMgd();
    private SitterManagerMgd sitterManagerMgd = new SitterManagerMgd(sitterRepositoryMgd);

    @Test
    public void sitterAddTest(){
        long collectionSize = sitterManagerMgd.getSize();
        assertTrue(sitterManagerMgd.add("Wojciech", "Kowalski", SitterMgd.SitterType.ACADEMIC, 100, "Maths", 10, true));
        assertEquals(collectionSize+1, sitterManagerMgd.getSize());
        assertTrue(sitterManagerMgd.add("Katarzyna", "Nowak", SitterMgd.SitterType.HOUSEKEEPER, 110, "Cooking", 7, true));
        assertEquals(collectionSize+2, sitterManagerMgd.getSize());
    }

    @Test
    public void sitterGetTest(){
        SitterMgd sitterMgd = new SitterMgd("Wojciech", "Kowalski", SitterMgd.SitterType.ACADEMIC, 100, "Maths", 10, true);
        assertNotNull(sitterRepositoryMgd.add(sitterMgd));

        assertEquals(sitterMgd, sitterRepositoryMgd.get(sitterMgd));
        assertEquals(sitterMgd.getEntityId().getUuid(), sitterRepositoryMgd.get(sitterMgd).getEntityId().getUuid());
        assertEquals(sitterMgd, sitterRepositoryMgd.getByEntityId(sitterMgd.getEntityId()));
        assertEquals(sitterMgd.getFirstName(), sitterRepositoryMgd.get(sitterMgd).getFirstName());
        assertEquals(sitterMgd.getLastName(), sitterRepositoryMgd.get(sitterMgd).getLastName());
        assertEquals(sitterMgd.getSitterType(), sitterRepositoryMgd.get(sitterMgd).getSitterType());
        assertEquals(sitterMgd.getBasePrice(), sitterRepositoryMgd.get(sitterMgd).getBasePrice());
        assertEquals(sitterMgd.getSkill(), sitterRepositoryMgd.get(sitterMgd).getSkill());
        assertEquals(sitterMgd.getMinAge(), sitterRepositoryMgd.get(sitterMgd).getMinAge());

    }

    @Test
    public void sitterUpdateTest(){
        SitterMgd sitterMgd = new SitterMgd("Katarzyna", "Nowak", SitterMgd.SitterType.HOUSEKEEPER, 110, "Cooking", 7, true);
        assertNotNull(sitterRepositoryMgd.add(sitterMgd));

        sitterMgd.setFirstName("Anna");
        sitterMgd.setLastName("Jankowska");
        sitterMgd.setSitterType(SitterMgd.SitterType.ACADEMIC);
        sitterMgd.setBasePrice(90);
        sitterMgd.setSkill("Cleaning");
        sitterMgd.setMinAge(5);
        sitterMgd.setAvailable(false);

        assertEquals("Anna", sitterMgd.getFirstName());
        assertEquals("Jankowska", sitterMgd.getLastName());
        assertEquals(SitterMgd.SitterType.ACADEMIC, sitterMgd.getSitterType());
        assertEquals(90, sitterMgd.getBasePrice());
        assertEquals("Cleaning", sitterMgd.getSkill());
        assertEquals(5, sitterMgd.getMinAge());
        assertEquals(false, sitterMgd.getIsAvailable());

        sitterRepositoryMgd.update(sitterMgd);

        SitterMgd sitterMgd_updated = sitterRepositoryMgd.getByEntityId(sitterMgd.getEntityId());

        assertEquals(sitterMgd.getFirstName(), sitterMgd_updated.getFirstName());
        assertEquals(sitterMgd.getLastName(), sitterMgd_updated.getLastName());
        assertEquals(sitterMgd.getSitterType(), sitterMgd_updated.getSitterType());
        assertEquals(sitterMgd.getBasePrice(), sitterMgd_updated.getBasePrice());
        assertEquals(sitterMgd.getSkill(), sitterMgd_updated.getSkill());
        assertEquals(sitterMgd.getMinAge(), sitterMgd_updated.getMinAge());
        assertEquals(sitterMgd.getIsAvailable(), sitterMgd_updated.getIsAvailable());
    }

    @Test
    public void sitterRemoveTest(){
        SitterMgd sitterMgd_1 = new SitterMgd("Wojciech", "Kowalski", SitterMgd.SitterType.ACADEMIC, 100, "Maths", 10, true);
        SitterMgd sitterMgd_2 = new SitterMgd("Katarzyna", "Nowak", SitterMgd.SitterType.HOUSEKEEPER, 110, "Cooking", 7, true);

        assertNotNull(sitterRepositoryMgd.add(sitterMgd_1));
        assertNotNull(sitterRepositoryMgd.add(sitterMgd_2));

        long collectionSize = sitterManagerMgd.getSize();

        sitterManagerMgd.remove(sitterMgd_1);
        assertEquals(collectionSize-1, sitterManagerMgd.getSize());
        sitterManagerMgd.remove(sitterMgd_2);
        assertEquals(collectionSize-2, sitterManagerMgd.getSize());
    }

}
