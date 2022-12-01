import managers.SitterManager;
import model.Sitter;
import org.junit.Test;
import repositories.SitterRepository;

import static org.junit.jupiter.api.Assertions.*;
public class SitterTest {
    private static final SitterRepository sitterRepository = new SitterRepository();
    private SitterManager sitterManager = new SitterManager(sitterRepository);

    @Test
    public void sitterAddTest(){
        long collectionSize = sitterManager.getSize();
        assertTrue(sitterManager.add("Wojciech", "Kowalski", Sitter.SitterType.ACADEMIC, 100, "Maths", 10, true));
        assertEquals(collectionSize+1, sitterManager.getSize());
        assertTrue(sitterManager.add("Katarzyna", "Nowak", Sitter.SitterType.HOUSEKEEPER, 110, "Cooking", 7, true));
        assertEquals(collectionSize+2, sitterManager.getSize());
    }

    @Test
    public void sitterGetTest(){
        Sitter sitter = new Sitter("Wojciech", "Kowalski", Sitter.SitterType.ACADEMIC, 100, "Maths", 10, true);
        assertNotNull(sitterRepository.add(sitter));

        assertEquals(sitter.getEntityId().getUuid(), sitterRepository.get(sitter).getEntityId().getUuid());
        assertEquals(sitter.getEntityId().getUuid(), sitterRepository.getByEntityId(sitter.getEntityId()).getEntityId().getUuid());
        assertEquals(sitter.getFirstName(), sitterRepository.get(sitter).getFirstName());
        assertEquals(sitter.getLastName(), sitterRepository.get(sitter).getLastName());
        assertEquals(sitter.getSitterType(), sitterRepository.get(sitter).getSitterType());
        assertEquals(sitter.getBasePrice(), sitterRepository.get(sitter).getBasePrice());
        assertEquals(sitter.getSkill(), sitterRepository.get(sitter).getSkill());
        assertEquals(sitter.getMinAge(), sitterRepository.get(sitter).getMinAge());

    }

    @Test
    public void sitterUpdateTest(){
        Sitter sitter = new Sitter("Katarzyna", "Nowak", Sitter.SitterType.HOUSEKEEPER, 110, "Cooking", 7, true);
        assertNotNull(sitterRepository.add(sitter));

        sitter.setFirstName("Anna");
        sitter.setLastName("Jankowska");
        sitter.setBasePrice(90);
        sitter.setSkill("Cleaning");
        sitter.setMinAge(5);
        sitter.setAvailable(false);

        assertEquals("Anna", sitter.getFirstName());
        assertEquals("Jankowska", sitter.getLastName());
        assertEquals(90, sitter.getBasePrice());
        assertEquals("Cleaning", sitter.getSkill());
        assertEquals(5, sitter.getMinAge());
        assertEquals(false, sitter.isAvailable());

        sitterRepository.update(sitter);

        Sitter sitter_updated = sitterRepository.getByEntityId(sitter.getEntityId());

        assertEquals(sitter.getFirstName(), sitter_updated.getFirstName());
        assertEquals(sitter.getLastName(), sitter_updated.getLastName());
        assertEquals(sitter.getSitterType(), sitter_updated.getSitterType());
        assertEquals(sitter.getBasePrice(), sitter_updated.getBasePrice());
        assertEquals(sitter.getSkill(), sitter_updated.getSkill());
        assertEquals(sitter.getMinAge(), sitter_updated.getMinAge());
        assertEquals(sitter.isAvailable(), sitter_updated.isAvailable());
    }

    @Test
    public void sitterRemoveTest(){
        Sitter sitter_1 = new Sitter("Wojciech", "Kowalski", Sitter.SitterType.ACADEMIC, 100, "Maths", 10, true);
        Sitter sitter_2 = new Sitter("Katarzyna", "Nowak", Sitter.SitterType.HOUSEKEEPER, 110, "Cooking", 7, true);

        assertNotNull(sitterRepository.add(sitter_1));
        assertNotNull(sitterRepository.add(sitter_2));

        long collectionSize = sitterManager.getSize();

        sitterManager.remove(sitter_1);
        assertEquals(collectionSize-1, sitterManager.getSize());
        sitterManager.remove(sitter_2);
        assertEquals(collectionSize-2, sitterManager.getSize());
    }

}