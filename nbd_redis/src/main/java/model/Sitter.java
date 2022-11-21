package model;

import entity.AbstractEntity;
import entity.UniqueId;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sitter extends AbstractEntity {
    @JsonbCreator
    public Sitter(@JsonbProperty("_id") UniqueId entityId,
                  @JsonbProperty("first_name") String firstName,
                  @JsonbProperty("last_name") String lastName,
                  @JsonbProperty("sitter_type") SitterType sitterType,
                  @JsonbProperty("base_price") double basePrice,
                  @JsonbProperty("skill") String skill,
                  @JsonbProperty("min_age") Integer minAge,
                  @JsonbProperty("is_available") boolean available) {
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

    @JsonbProperty("first_name")
    private String firstName;
    @JsonbProperty("last_name")
    private String lastName;
    @JsonbProperty("sitter_type")
    private SitterType  sitterType;
    @JsonbProperty("base_price")
    private double basePrice;
    @JsonbProperty("skill")
    private String skill;
    @JsonbProperty("min_age")
    private Integer minAge;
    @JsonbProperty("is_available")
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
