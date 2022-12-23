package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import entity.AbstractEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"parent_id", "sitter_id", "date", "startTime", "endTime"})
@Entity
@CqlName("reservations_id")
public class Reservation extends AbstractEntity {
    @NonNull
    @PartitionKey
    @CqlName("reservation_id")
    private String reservation_id;

    @NonNull
    @CqlName("parent_id")
    private String parent;
    @NonNull
    @CqlName("sitter_id")
    private String sitter;

    @NonNull
    @CqlName("date")
    private LocalDate date;
    @NonNull
    @CqlName("startTime")
    private LocalTime startTime;
    @NonNull
    @CqlName("endTime")
    private LocalTime endTime;

}
