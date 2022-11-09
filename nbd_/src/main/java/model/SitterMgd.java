package model;

import entity.AbstractEntityMgd;
import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class SitterMgd extends AbstractEntityMgd {
    @BsonCreator
    public SitterMgd(@BsonProperty("_id") UniqueIdMgd entityId,
                     @BsonProperty("firstname") String firstName,
                     @BsonProperty("lastname") String lastName,
                     @BsonProperty("baseprice") double basePrice) {
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
