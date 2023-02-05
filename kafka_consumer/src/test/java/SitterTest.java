import managers.SitterManager;
import model.Sitter;
import org.junit.jupiter.api.Test;
import repositories.SitterRepository;

import static org.junit.jupiter.api.Assertions.*;

public class SitterTest {
    private static final SitterRepository sitterRepository = new SitterRepository();
    private static final SitterManager sitterManager = new SitterManager(sitterRepository);

    @Test
    public void addTest() {
        Sitter sitter1 = new Sitter("Anna", "Nowak", Sitter.SitterType.ACADEMIC, 30, "Matematyka", 7, true);
        Sitter sitter2 = new Sitter("Wojciech", "Kowalski", Sitter.SitterType.HOUSEKEEPER, 30, "Gotowanie", 8, true);
        long sitterRepositorySizeR = sitterRepository.getCollectionSize();
        assertNotNull(sitterRepository.add(sitter1));
        assertEquals(sitterRepositorySizeR + 1, sitterRepository.getCollectionSize());
        assertNotNull(sitterRepository.add(sitter2));
        assertEquals(sitterRepositorySizeR + 2, sitterRepository.getCollectionSize());

        long sitterRepositorySizeM = sitterRepository.getCollectionSize();
        assertTrue(sitterManager.add("Kacper", "Nowacki", Sitter.SitterType.ACADEMIC, 25, "Fizyka", 10, true));
        assertEquals(sitterRepositorySizeM + 1, sitterRepository.getCollectionSize());
        assertTrue(sitterManager.add("Krzysztof", "Kowal", Sitter.SitterType.HOUSEKEEPER, 35, "Pranie", 10, true));
        assertEquals(sitterRepositorySizeM + 2, sitterRepository.getCollectionSize());
    }

    @Test
    public void getTest() {
        Sitter sitter = new Sitter("Anna", "Krzak", Sitter.SitterType.ACADEMIC, 30, "Matematyka", 8, true);
        assertNotNull(sitterRepository.add(sitter));
        assertEquals(sitter.getEntityId().getUuid(), sitterRepository.get(sitter).getEntityId().getUuid());
    }

    @Test
    public void removeTest() {
        Sitter sitter1 = new Sitter("Anna", "Nowak", Sitter.SitterType.ACADEMIC, 30, "Matematyka", 7, true);
        Sitter sitter2 = new Sitter("Wojciech", "Kowalski", Sitter.SitterType.HOUSEKEEPER, 30, "Gotowanie", 8, true);
        assertNotNull(sitterRepository.add(sitter1));
        assertNotNull(sitterRepository.add(sitter2));
        long sitterRepositorySize = sitterRepository.getCollectionSize();
        sitterRepository.remove(sitter1);
        assertEquals(sitterRepositorySize - 1, sitterRepository.getCollectionSize());
        sitterManager.remove(sitter2);
        assertEquals(sitterRepositorySize - 2, sitterRepository.getCollectionSize());
    }

    @Test
    public void updateTest() {
        Sitter sitter = new Sitter("Mariusz", "Busz", Sitter.SitterType.ACADEMIC, 30, "Matematyka", 8, true);
        assertNotNull(sitterRepository.add(sitter));

        sitter.setFirstName("Marek");
        sitter.setLastName("Buch");
        sitter.setBasePrice(24);
        sitter.setSkill("Biologia");
        sitter.setMinAge(9);
        sitter.setAvailable(false);
        sitterRepository.update(sitter);

        Sitter updated = sitterRepository.getByEntityId(sitter.getEntityId());
        assertEquals(sitter.getFirstName(), updated.getFirstName());
        assertEquals(sitter.getLastName(), updated.getLastName());
        assertEquals(sitter.getBasePrice(), updated.getBasePrice());
        assertEquals(sitter.getSkill(), updated.getSkill());
        assertEquals(sitter.getMinAge(), updated.getMinAge());
        assertEquals(sitter.isAvailable(), updated.isAvailable());
    }
}
