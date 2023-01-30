package managers;


import entity.UniqueId;
import model.Parent;
import repositories.ParentRepository;

public class ParentManager {
    ParentRepository parentRepository;

    public ParentManager(ParentRepository parentRepository){
        this.parentRepository = parentRepository;
    }
    //C
    public boolean add(String name, String address, String phoneNumber, Integer childAge){
        Parent parent = new Parent(name, address, phoneNumber, childAge);
        return parentRepository.add(parent) != null;
    }
    //R
    public Parent get(Parent parent){
        return parentRepository.get(parent);
    }

    public Parent get(UniqueId entityId){
        return parentRepository.getByEntityId(entityId);
    }
    //U
    public void update(Parent parent){
        parentRepository.update(parent);
    }
    //D
    public void remove(Parent parent){
        parentRepository.remove(parent);
    }

    public long getSize (){
        return parentRepository.getCollectionSize();
    }
}
