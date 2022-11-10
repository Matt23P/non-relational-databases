package model;

import entity.AbstractEntityMgd;
import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationMgd extends AbstractEntityMgd {
    @BsonCreator
    public ReservationMgd(@BsonProperty("_id") UniqueIdMgd entityId,
                          @BsonProperty("date") LocalDate date,
                          @BsonProperty("start_hour") LocalTime startTime,
                          @BsonProperty("end_hour") LocalTime endTime) {
        super(entityId);
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ReservationMgd(LocalDate date, LocalTime startTime, LocalTime endTime) {
        super(new UniqueIdMgd());
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @BsonProperty
    private LocalDate date;
    @BsonProperty
    private LocalTime startTime;
    @BsonProperty
    private LocalTime endTime;

}
