package dao;

import com.datastax.oss.driver.api.mapper.annotations.*;
import model.Reservation;
import com.datastax.oss.driver.api.core.cql.ResultSet;

@Dao
public interface ReservationDao {

    @Insert
    void createReservation(Reservation reservation);

    @GetEntity
    Reservation readReservation(ResultSet resultSet);

    @Update
    void updateReservation(Reservation reservation);

    @Delete
    void deleteReservation(Reservation reservation);
}
