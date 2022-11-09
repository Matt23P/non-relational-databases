package model;

import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class AcademicMgd extends SitterMgd {

    @BsonCreator
    public AcademicMgd(@BsonProperty UniqueIdMgd entityId,
                       @BsonProperty String firstName,
                       @BsonProperty String lastName,
                       @BsonProperty double basePrice,
                       @BsonProperty String subject,
                       @BsonProperty int maxAge,
                       @BsonProperty double bonus) {
        super(entityId, firstName, lastName, basePrice);
        this.subject = subject;
        this.maxAge = maxAge;
        this.bonus = bonus;
    }

    @BsonProperty
    private String subject;

    @BsonProperty
    private int maxAge;

    @BsonProperty
    private double bonus;
}
