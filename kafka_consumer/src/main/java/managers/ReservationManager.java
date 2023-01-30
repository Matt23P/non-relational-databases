package managers;

import entity.UniqueId;
import model.Parent;
import model.Reservation;
import model.Sitter;
import repositories.ReservationRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationManager {
    ReservationRepository reservationRepository;
    public ReservationManager(ReservationRepository reservationRepository){ this.reservationRepository = reservationRepository; }

    public boolean add(LocalDate date, LocalTime startTime, LocalTime endTime, Parent parent, Sitter sitter){
        Reservation reservation = new Reservation(date, startTime, endTime, parent, sitter);
        return reservationRepository.add(reservation) != null;
    }

    public boolean add(Reservation reservation){
        return reservationRepository.add(reservation) != null;
    }

    public Reservation get(Reservation reservation){ return reservationRepository.get(reservation); }

    public Reservation get(UniqueId entityId){ return reservationRepository.getByEntityId(entityId); }

    public void update(Reservation reservation){ reservationRepository.update(reservation); }

    public void remove(Reservation reservation){ reservationRepository.remove(reservation); }

    public long getSize(){ return reservationRepository.getCollectionSize(); }
}