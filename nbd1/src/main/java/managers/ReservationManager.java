package managers;

import repositories.ReservationRepository;

public class ReservationManager {
    ReservationRepository reservationRepository;

    public ReservationManager(ReservationRepository reservationRepository1) {
        this.reservationRepository = reservationRepository1;
    }
}
