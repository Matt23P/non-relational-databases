package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import entity.AbstractEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"firstName", "lastName", "basePrice", "skill", "minAge", "available", "sitterType"})
@CqlName("sitters_id")
@Entity()

public class Sitter extends AbstractEntity {

    @NonNull
    @PartitionKey
    @CqlName("sitter_id")
    private String sitter_id;

    @NonNull
    @CqlName("firstName")
    private String firstName;
    @NonNull
    @CqlName("lastName")
    private String lastName;
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
    public enum SitterType implements Serializable {
        ACADEMIC,
        HOUSEKEEPER;

        @NonNull
        @Getter
        @CqlName("typeInfo")
        private String typeInfo;
    }

    @CqlName("sitterType")
    private String sitterType = SitterType.ACADEMIC.typeInfo;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
