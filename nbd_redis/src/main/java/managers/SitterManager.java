package managers;

import entity.UniqueId;
import model.Sitter;
import repositories.SitterRepository;

public class SitterManager {
    SitterRepository sitterRepository;

    public SitterManager(SitterRepository sitterRepository){ this.sitterRepository = sitterRepository; }
    //C
    public boolean add(String firstName, String lastName, Sitter.SitterType sitterType, double basePrice, String skill, Integer minAge, boolean isAvailable){
        Sitter sitter = new Sitter(firstName, lastName, sitterType, basePrice, skill, minAge, isAvailable);
        return sitterRepository.add(sitter) != null;
    }
    //R
    public Sitter get(Sitter sitter){ return sitterRepository.get(sitter); }

    public Sitter get(UniqueId entityId){ return sitterRepository.getByEntityId(entityId); }
    //U
    public void update(Sitter sitter){ sitterRepository.update(sitter); }
    //D
    public void remove(Sitter sitter){ sitterRepository.remove(sitter); }

    public long getSize(){ return sitterRepository.getCollectionSize(); }

    public void setAvailable(Sitter sitter, boolean available) { sitterRepository.setAvailable(sitter, available); }

    public boolean getIsAvailable(Sitter sitter){ return sitterRepository.getAvailable(sitter); }
}