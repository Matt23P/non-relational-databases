package dao;

import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.GetEntity;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import model.Reservation;

import java.sql.ResultSet;

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
