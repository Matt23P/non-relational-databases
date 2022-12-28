package managers;


import model.Sitter;
import repositories.SitterRepository;

public class SitterManager {
    SitterRepository sitterRepository;

    public SitterManager(SitterRepository sitterRepository) {
        this.sitterRepository = sitterRepository;
    }

    public boolean add(String sitter_id, String firstName, String lastName, double basePrice, String skill, Integer minAge, boolean available, String sitterType) {
        Sitter sitter = new Sitter(sitter_id, firstName, lastName, basePrice, skill, minAge, available, sitterType);
        sitterRepository.add(sitter);
        return true;
    }

    public void remove(Sitter sitter) {
        sitterRepository.remove(sitter);
    }

    public Sitter get(Sitter sitter) {
        return sitterRepository.get(sitter);
    }
}