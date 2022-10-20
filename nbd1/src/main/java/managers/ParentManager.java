package managers;

import repositories.ParentRepository;
import model.Parent;

public class ParentManager {
    ParentRepository parentRepository;

    public ParentManager(ParentRepository parentRepository1) {
        this.parentRepository = parentRepository1;
    }

    public Parent add(String name, String address, String phoneNumber){
        Parent parent = new Parent(name, address, phoneNumber);
        return parentRepository.add(parent);
    }
    public Parent get(Long parentId){return parentRepository.get(parentId);}
    public boolean remove(Parent parent){return parentRepository.remove(parent);}
}
