package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import entity.AbstractEntity;
//import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@CqlName("reservations_id")
public class Reservation extends AbstractEntity {

    @PartitionKey
    @CqlName("reservation_id")
    private String reservation_id;

    @CqlName("parent_id")
    private String parent_id;

    @CqlName("sitter_id")
    private String sitter_id;

    @CqlName("date")
    private LocalDate date;

    @CqlName("startTime")
    private LocalTime startTime;

    @CqlName("endTime")
    private LocalTime endTime;

    public String getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(String reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getSitter_id() {
        return sitter_id;
    }

    public void setSitter_id(String sitter_id) {
        this.sitter_id = sitter_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Reservation(String reservation_id, String parent_id, String sitter_id, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.reservation_id = reservation_id;
        this.parent_id = parent_id;
        this.sitter_id = sitter_id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Reservation() {
    }
}
