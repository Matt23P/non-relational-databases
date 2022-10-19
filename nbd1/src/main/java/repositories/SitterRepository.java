package repositories;

import entity.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import model.Sitter;

public class SitterRepository implements Repository<Sitter, Long> {
    public Sitter add(Sitter object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(object);
            manager.getTransaction().commit();
            return object;
        }
    }

    public Sitter get(Long id) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            return manager.find(Sitter.class, id);
        }
    }

    public void remove(Sitter object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.remove(manager.merge(object));
            manager.getTransaction().commit();
        }
    }
}
