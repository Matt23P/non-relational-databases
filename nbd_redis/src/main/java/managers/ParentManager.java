package managers;

import model.Parent;
import repositories.ParentRepository;

public class ParentManager {
   ParentRepository parentRepository;

   public ParentManager(ParentRepository parentRepository) {
       this.parentRepository = parentRepository;
   }

   public boolean add(String parent_id, String name, String address, String phoneNumber, Integer childAge) {
       Parent parent = new Parent(parent_id, name, address, phoneNumber, childAge);
       parentRepository.add(parent);
       return true;
   }

   public void remove(Parent parent) {
       parentRepository.remove(parent);
   }

   public Parent get(Parent parent) {
       return parentRepository.get(parent);
   }
}
