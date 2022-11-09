package model;

import entity.AbstractEntityMgd;
import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class SitterMgd extends AbstractEntityMgd {
    @BsonCreator
    public SitterMgd(@BsonProperty("_id") UniqueIdMgd entityId,
                     @BsonProperty("first_name") String firstName,
                     @BsonProperty("last_name") String lastName,
                     @BsonProperty("base_price") double basePrice) {
        super(entityId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.basePrice = basePrice;
    }

    @BsonProperty
    private String firstName;
    @BsonProperty
    private String lastName;
    @BsonProperty
    private double basePrice;

}
