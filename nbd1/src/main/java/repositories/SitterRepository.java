package repositories;

import entity.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import model.Academic;
import model.Housekeeper;
import model.Sitter;

import static model.Sitter_.sitterId;

public class SitterRepository implements Repository<Sitter, Long> {
    public Sitter add(Sitter object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(object);
            manager.getTransaction().commit();
            return object;
        } catch (IllegalArgumentException persistenceException) {
            return null;
        }
    }

    public Housekeeper add(Housekeeper object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(object);
            manager.getTransaction().commit();
            return object;
        }catch (IllegalArgumentException persistenceException) {
            return null;
        }
    }

    public Academic add(Academic object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(object);
            manager.getTransaction().commit();
            return object;
        }catch (IllegalArgumentException persistenceException) {
            return null;
        }
    }

    public Sitter get(Long id) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            return manager.find(Sitter.class, sitterId);
        }
    }

    public boolean remove(Sitter object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.remove(manager.merge(object));
            manager.getTransaction().commit();
            return true;
        } catch (IllegalArgumentException persistenceException) {
            return false;
        }
    }
}
