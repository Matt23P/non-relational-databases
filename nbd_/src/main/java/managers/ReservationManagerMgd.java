package managers;

import entity.UniqueIdMgd;
import model.ParentMgd;
import model.ReservationMgd;
import model.SitterMgd;
import repositories.ReservationRepositoryMgd;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationManagerMgd {
    ReservationRepositoryMgd reservationRepositoryMgd;
    public ReservationManagerMgd(ReservationRepositoryMgd reservationRepositoryMgd){ this.reservationRepositoryMgd = reservationRepositoryMgd; }

    public boolean add(LocalDate date, LocalTime startTime, LocalTime endTime, ParentMgd parent, SitterMgd sitter){
        if(sitter.getIsAvailable()){
            ReservationMgd reservationMgd = new ReservationMgd(date, startTime, endTime, parent, sitter);
            return reservationRepositoryMgd.add(reservationMgd) != null;
        }
        return false;
    }

    public ReservationMgd get(ReservationMgd reservationMgd){ return reservationRepositoryMgd.get(reservationMgd); }

    public ReservationMgd get(UniqueIdMgd entityId){ return reservationRepositoryMgd.getByEntityId(entityId); }

    public void update(ReservationMgd reservationMgd){ reservationRepositoryMgd.update(reservationMgd); }

    public void remove(ReservationMgd reservationMgd){ reservationRepositoryMgd.remove(reservationMgd); }

    public long getSize(){ return reservationRepositoryMgd.getCollectionSize(); }
}
