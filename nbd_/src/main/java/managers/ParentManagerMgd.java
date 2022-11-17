package managers;
import entity.UniqueIdMgd;
import model.ParentMgd;
import repositories.ParentRepositoryMgd;

public class ParentManagerMgd {
    ParentRepositoryMgd parentRepositoryMgd;

    public ParentManagerMgd(ParentRepositoryMgd parentRepositoryMgd){
        this.parentRepositoryMgd = parentRepositoryMgd;
    }
//C
    public boolean add(String name, String address, String phoneNumber, Integer childAge){
        ParentMgd parentMgd = new ParentMgd(name, address, phoneNumber, childAge);
        return parentRepositoryMgd.add(parentMgd) != null;
    }
//R
    public ParentMgd get(ParentMgd parentMgd){
        return parentRepositoryMgd.get(parentMgd);
    }

    public ParentMgd get(UniqueIdMgd entityId){
        return parentRepositoryMgd.getByEntityId(entityId);
    }
//U
    public void update(ParentMgd parentMgd){
        parentRepositoryMgd.update(parentMgd);
    }
//D
    public void remove(ParentMgd parentMgd){
        parentRepositoryMgd.remove(parentMgd);
    }

    public long getSize (){
        return parentRepositoryMgd.getCollectionSize();
    }
}
