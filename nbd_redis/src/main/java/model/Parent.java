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
@CqlName("parents_id")
public class Parent extends AbstractEntity {

    public Parent(String name, String address, String phoneNumber, Integer childAge) {
        super(new UniqueId());
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.childAge = childAge;
    }

    @NonNull
    @CqlName("name")
    private String name;
    @NonNull
    @CqlName("address")
    private String address;
    @NonNull
    @CqlName("phoneNumber")
    private String phoneNumber;
    @NonNull
    @CqlName("childAge")
    private Integer childAge;
}
