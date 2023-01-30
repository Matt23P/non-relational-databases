package model;

import entity.AbstractEntity;
import entity.UniqueId;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Reservation extends AbstractEntity {
    @BsonCreator
    public Reservation(@BsonId UniqueId entityId,
                          @BsonProperty("date") LocalDate date,
                          @BsonProperty("start_hour") LocalTime startTime,
                          @BsonProperty("end_hour") LocalTime endTime,
                          @BsonProperty("parent") Parent parent,
                          @BsonProperty("sitter") Sitter sitter) {
        super(entityId);
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parent = parent;
        this.sitter = sitter;
        sitter.setAvailable(false);
    }


    public Reservation(LocalDate date, LocalTime startTime, LocalTime endTime, Parent parent, Sitter sitter) {
        super(new UniqueId());
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parent = parent;
        this.sitter = sitter;
        sitter.setAvailable(false);
    }


    @BsonProperty("date")
    private LocalDate date;
    @BsonProperty("start_time")
    private LocalTime startTime;
    @BsonProperty("end_time")
    private LocalTime endTime;
    @BsonProperty("parent")
    private Parent parent;
    @BsonProperty("sitter")
    private Sitter sitter;
}
