package repositories;

import entity.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import model.Parent;

import static model.Parent_.parentId;

public class ParentRepository implements Repository<Parent, Long> {
    @Override
    public Parent add(Parent object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(object);
            manager.getTransaction().commit();
            return object;
        }
    }

    @Override
    public Parent get(Long id) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            return manager.find(Parent.class, parentId);
        }
    }

    @Override
    public boolean remove(Parent object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.remove(manager.merge(object));
            manager.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
