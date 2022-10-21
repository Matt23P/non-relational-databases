package managers;

import model.*;
import repositories.ReservationRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationManager {
    ReservationRepository reservationRepository;

    public ReservationManager(ReservationRepository reservationRepository1) {
        this.reservationRepository = reservationRepository1;
    }
    //Sitter - basic
    public Reservation add(LocalDate date, LocalTime startHour, LocalTime endHour, Sitter sitter, Parent parent) {
        Reservation reservation = new Reservation(date, startHour, endHour, sitter, parent);
        return reservationRepository.add(reservation);
    }
    //Sitter - type Housekeeper
    public Reservation add(LocalDate date, LocalTime startHour, LocalTime endHour, Housekeeper sitter, Parent parent) {
        Reservation reservation = new Reservation(date, startHour, endHour, sitter, parent);
        return reservationRepository.add(reservation);
    }
    //Sitter - type Academic
    public Reservation add(LocalDate date, LocalTime startHour, LocalTime endHour, Academic sitter, Parent parent) {
        Reservation reservation = new Reservation(date, startHour, endHour, sitter, parent);
        return reservationRepository.add(reservation);
    }

    public Reservation get(Long reservationId) {
        return reservationRepository.get(reservationId);
    }

    public boolean remove(Reservation reservation) {
        return reservationRepository.remove(reservation);
    }

}
