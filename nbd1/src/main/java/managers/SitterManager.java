package managers;

import model.Academic;
import model.Housekeeper;
import repositories.SitterRepository;
import model.Sitter;

public class SitterManager {
    SitterRepository sitterRepository;

    public SitterManager(SitterRepository sitterRepository1) {
        this.sitterRepository = sitterRepository1;
    }
    //add basic Sitter
    public Sitter add(String firstName, String lastName, double basePrice) {
        Sitter sitter = new Sitter(firstName, lastName, basePrice);
        return sitterRepository.add(sitter);
    }
    //add Housekeeper type Sitter
    public Housekeeper add(String firstName, String lastName, double basePrice, String skill) {
        Housekeeper sitter = new Housekeeper(firstName, lastName, basePrice, skill);
        return sitterRepository.add(sitter);
    }
    //add Academic type Sitter
    public Academic add(String firstName, String lastName, double basePrice, String subject, int max_age, double bonus) {
        Academic sitter = new Academic(firstName, lastName, basePrice, subject, max_age, bonus);
        return sitterRepository.add(sitter);
    }
    public Sitter get(Long sitterId) {
        return sitterRepository.get(sitterId);
    }

    public boolean remove(Sitter sitter) {
        return sitterRepository.remove(sitter);
    }
}
