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
                          @BsonProperty("starthour") LocalTime startTime,
                          @BsonProperty("end_hour") LocalTime endTime,
                          @BsonProperty("sitterid") SitterMgd sitter,
                          @BsonProperty("parentid") ParentMgd parent) {
        super(entityId);
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sitter = sitter;
        this.parent = parent;
    }

    @BsonProperty
    private LocalDate date;
    @BsonProperty
    private LocalTime startTime;
    @BsonProperty
    private LocalTime endTime;

    @BsonProperty
    private SitterMgd sitter;

    @BsonProperty
    private ParentMgd parent;
}
