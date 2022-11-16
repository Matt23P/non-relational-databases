package model;

import entity.AbstractEntityMgd;
import entity.UniqueIdMgd;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
public class ReservationMgd extends AbstractEntityMgd {
    @BsonCreator
    public ReservationMgd(@BsonId UniqueIdMgd entityId,
                          @BsonProperty("date") LocalDate date,
                          @BsonProperty("start_hour") LocalTime startTime,
                          @BsonProperty("end_hour") LocalTime endTime,
                          @BsonProperty("parent") ParentMgd parent,
                          @BsonProperty("sitter") SitterMgd sitter) {
        super(entityId);
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parent = parent;
        this.sitter = sitter;
        sitter.setAvailable(false);
    }


    public ReservationMgd(LocalDate date, LocalTime startTime, LocalTime endTime, ParentMgd parent, SitterMgd sitter) {
        super(new UniqueIdMgd());
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parent = parent;
        this.sitter = sitter;
        sitter.setAvailable(false);
    }


    @BsonProperty
    private LocalDate date;
    @BsonProperty
    private LocalTime startTime;
    @BsonProperty
    private LocalTime endTime;
    @BsonProperty
    private ParentMgd parent;
    @BsonProperty
    private SitterMgd sitter;

}
