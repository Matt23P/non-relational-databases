package model;

import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class AcademicMgd extends SitterMgd {

    @BsonCreator
    public AcademicMgd(@BsonProperty("_id") UniqueIdMgd entityId,
                       @BsonProperty("first_name") String firstName,
                       @BsonProperty("last_name") String lastName,
                       @BsonProperty("base_price") double basePrice,
                       @BsonProperty("subject") String subject,
                       @BsonProperty("max_age") int maxAge,
                       @BsonProperty("bonus") double bonus) {
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
