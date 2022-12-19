package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import entity.AbstractEntity;
import entity.UniqueId;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity(defaultKeyspace = "sitter")
@CqlName("reservations_id")
public class Reservation extends AbstractEntity {

    public Reservation(LocalDate date, LocalTime startTime, LocalTime endTime, Parent parent, Sitter sitter) {
        super(new UniqueId());
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parent = parent;
        this.sitter = sitter;
        sitter.setAvailable(false);
    }


    @NonNull
    @CqlName("date")
    private LocalDate date;
    @NonNull
    @CqlName("startTime")
    private LocalTime startTime;
    @NonNull
    @CqlName("endTime")
    private LocalTime endTime;
    @NonNull
    @CqlName("parent")
    private Parent parent;
    @NonNull
    @CqlName("sitter")
    private Sitter sitter;
}
