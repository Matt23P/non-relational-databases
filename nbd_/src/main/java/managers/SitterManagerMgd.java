package managers;

import entity.UniqueIdMgd;
import model.SitterMgd;
import repositories.SitterRepositoryMgd;

public class SitterManagerMgd {
    SitterRepositoryMgd sitterRepositoryMgd;

    public SitterManagerMgd(SitterRepositoryMgd sitterRepositoryMgd){ this.sitterRepositoryMgd = sitterRepositoryMgd; }
//C
    public boolean add(String firstName, String lastName, SitterMgd.SitterType sitterType, double basePrice, String skill, Integer minAge, boolean isAvailable){
        SitterMgd sitterMgd = new SitterMgd(firstName, lastName, sitterType, basePrice, skill, minAge);
        return sitterRepositoryMgd.add(sitterMgd) != null;
    }
//R
    public SitterMgd get(SitterMgd sitterMgd){ return sitterRepositoryMgd.get(sitterMgd); }

    public SitterMgd get(UniqueIdMgd entityId){ return sitterRepositoryMgd.getByEntityId(entityId); }
//U
    public void update(SitterMgd sitterMgd){ sitterRepositoryMgd.update(sitterMgd); }
//D
    public void remove(SitterMgd sitterMgd){ sitterRepositoryMgd.remove(sitterMgd); }

    public long getSize(){ return sitterRepositoryMgd.getCollectionSize(); }

    public void setAvailable(SitterMgd sitterMgd, boolean available) { sitterRepositoryMgd.setAvailable(sitterMgd, available); }

    public boolean getIsAvailable(SitterMgd sitterMgd){ return sitterRepositoryMgd.getAvailable(sitterMgd); }
}
