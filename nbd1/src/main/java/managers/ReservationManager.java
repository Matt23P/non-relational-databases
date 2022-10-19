package managers;

import model.Parent;
import model.Reservation;
import model.Sitter;
import repositories.ReservationRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationManager {
    ReservationRepository reservationRepository;

    public ReservationManager(ReservationRepository reservationRepository1) {
        this.reservationRepository = reservationRepository1;
    }

    public Reservation add(LocalDate date, LocalTime startHour, LocalTime endHour, Sitter sitter, Parent parent){
        Reservation reservation = new Reservation(date, startHour, endHour, sitter, parent);
        return reservationRepository.add(reservation);
    }
    public Reservation get(Long reservationId){return reservationRepository.get(reservationId);}
    public void remove(Reservation reservation){reservationRepository.remove(reservation);}

}
