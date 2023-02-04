package model;

import entity.UniqueId;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@Setter
public class Sitter extends AbstractEntity {
    @BsonCreator
    public Sitter(@BsonId UniqueId entityId,
                     @BsonProperty("first_name") String firstName,
                     @BsonProperty("last_name") String lastName,
                     @BsonProperty("sitter_type") SitterType sitterType,
                     @BsonProperty("base_price") double basePrice,
                     @BsonProperty("skill") String skill,
                     @BsonProperty("min_age") Integer minAge,
                     @BsonProperty("is_available") boolean available) {
        super(entityId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.sitterType = sitterType;
        this.basePrice = basePrice;
        this.skill = skill;
        this.minAge = minAge;
        this.available = available;
    }

    public Sitter(String firstName, String lastName, SitterType sitterType, double basePrice, String skill, Integer minAge, boolean available) {
        super(new UniqueId());
        this.firstName = firstName;
        this.lastName = lastName;
        this.sitterType = sitterType;
        this.basePrice = basePrice;
        this.skill = skill;
        this.minAge = minAge;
        this.available = available;
    }

    @BsonProperty("first_name")
    private String firstName;
    @BsonProperty("last_name")
    private String lastName;
    @BsonProperty("sitter_type")
    private SitterType  sitterType;
    @BsonProperty("base_price")
    private double basePrice;
    @BsonProperty("skill")
    private String skill;
    @BsonProperty("min_age")
    private Integer minAge;
    @BsonProperty("is_available")
    private boolean available;

    public enum SitterType{
        ACADEMIC,
        HOUSEKEEPER
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}