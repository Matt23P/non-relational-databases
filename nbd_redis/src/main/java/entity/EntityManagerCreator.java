package entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerCreator {
    private static final EntityManagerFactory manager = Persistence.createEntityManagerFactory("SITTER");

    public static EntityManager getEntityManager() {
        return manager.createEntityManager();
    }
}
