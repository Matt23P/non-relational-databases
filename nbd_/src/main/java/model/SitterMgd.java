package model;

import entity.AbstractEntityMgd;
import entity.UniqueIdMgd;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@Setter
public class SitterMgd extends AbstractEntityMgd {
    @BsonCreator
    public SitterMgd(@BsonId UniqueIdMgd entityId,
                     @BsonProperty("first_name") String firstName,
                     @BsonProperty("last_name") String lastName,
                     @BsonProperty("base_price") double basePrice,
                     @BsonProperty("is_available") boolean isAvailable) {
        super(entityId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.basePrice = basePrice;
        this.isAvailable = isAvailable;
    }

    public SitterMgd(String firstName, String lastName, double basePrice) {
        super(new UniqueIdMgd());
        this.firstName = firstName;
        this.lastName = lastName;
        this.basePrice = basePrice;
        this.isAvailable = true;
    }

    @BsonProperty
    private String firstName;
    @BsonProperty
    private String lastName;
    @BsonProperty
    private double basePrice;
    @BsonProperty
    private boolean isAvailable;

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
