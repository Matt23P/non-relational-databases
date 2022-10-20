package repositories;

import entity.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import model.Reservation;

public class ReservationRepository implements Repository<Reservation, Long> {
    @Override
    public Reservation add(Reservation object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(object);
            manager.getTransaction().commit();
            return object;
        }
    }

    @Override
    public Reservation get(Long id) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            return manager.find(Reservation.class, id);
        }
    }

    @Override
    public boolean remove(Reservation object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.remove(manager.merge(object));
            manager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
