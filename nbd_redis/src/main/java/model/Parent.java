package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import entity.AbstractEntity;
import lombok.*;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"name", "address", "phoneNumber", "childAge"})
@CqlName("parents_id")
@Entity
public class Parent extends AbstractEntity {

    @NonNull
    @PartitionKey
    @CqlName("parent_id")
    private String client_id;
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
