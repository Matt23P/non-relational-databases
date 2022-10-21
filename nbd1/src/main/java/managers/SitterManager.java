package managers;

import repositories.SitterRepository;
import model.Sitter;

public class SitterManager {
    SitterRepository sitterRepository;

    public SitterManager(SitterRepository sitterRepository1) {
        this.sitterRepository = sitterRepository1;
    }

    public Sitter add(String firstName, String lastName, double basePrice){
        Sitter sitter = new Sitter(firstName, lastName, basePrice);
        return sitterRepository.add(sitter);
    }
    public Sitter get(Long sitterId){return sitterRepository.get(sitterId);}
    public boolean remove(Sitter sitter){return sitterRepository.remove(sitter);}
}
