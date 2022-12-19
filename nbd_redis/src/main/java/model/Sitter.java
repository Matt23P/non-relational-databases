package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import entity.AbstractEntity;
import entity.UniqueId;
import lombok.*;

@Getter
@Setter
@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(defaultKeyspace = "sitter")
@CqlName("sitters_id")
public class Sitter extends AbstractEntity {

//    public Sitter() {
//
//    }

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

    @NonNull
    @CqlName("firstName")
    private String firstName;
    @NonNull
    @CqlName("lastName")
    private String lastName;

    @CqlName("sitterType")
    private SitterType  sitterType;
    @NonNull
    @CqlName("basePrice")
    private double basePrice;
    @NonNull
    @CqlName("skill")
    private String skill;
    @NonNull
    @CqlName("minAge")
    private Integer minAge;
    @NonNull
    @CqlName("available")
    private boolean available;

    @ToString
    @RequiredArgsConstructor
    @NoArgsConstructor
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
