package managers;

import model.Reservation;
import repositories.ReservationRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationManager {
   ReservationRepository reservationRepository;

   public ReservationManager(ReservationRepository reservationRepository) {
       this.reservationRepository = reservationRepository;
   }

   public boolean add(String reservation_id, String parent_id, String sitter_id, LocalDate date, LocalTime startTime, LocalTime endTime) {
       Reservation reservation = new Reservation(reservation_id, parent_id, sitter_id, date, startTime, endTime);
       reservationRepository.add(reservation);
       return true;
   }

   public void remove(Reservation reservation) {
       reservationRepository.remove(reservation);
   }

   public Reservation get(Reservation reservation) {
       return reservationRepository.get(reservation);
   }
}