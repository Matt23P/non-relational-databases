package repositories;

import entity.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import model.Reservation;

import static model.Reservation_.reservationId;

public class ReservationRepository implements Repository<Reservation, Long> {
    @Override
    public Reservation add(Reservation object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.merge(object);
            manager.getTransaction().commit();
            return object;
        } catch (IllegalArgumentException persistenceException) {
            return null;
        }
    }

    @Override
    public Reservation get(Long id) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            return manager.find(Reservation.class, reservationId);
        }
    }

    @Override
    public boolean remove(Reservation object) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.remove(manager.merge(object));
            manager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
