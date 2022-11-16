package model;

import entity.UniqueIdMgd;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@Setter
public class AcademicMgd extends SitterMgd {

    @BsonCreator
    public AcademicMgd(@BsonId UniqueIdMgd entityId,
                       @BsonProperty("first_name") String firstName,
                       @BsonProperty("last_name") String lastName,
                       @BsonProperty("base_price") double basePrice,
                       @BsonProperty("subject") String subject,
                       @BsonProperty("max_age") int maxAge,
                       @BsonProperty("bonus") double bonus) {
        super(entityId, firstName, lastName, basePrice, true);
        this.subject = subject;
        this.maxAge = maxAge;
        this.bonus = bonus;
    }

    public AcademicMgd(
            String firstName,
            String lastName,
            double basePrice,
            String subject,
            int maxAge,
            double bonus) {
        super(new UniqueIdMgd(), firstName, lastName, basePrice, true);
        this.subject = subject;
        this.maxAge = maxAge;
        this.bonus = bonus;
    }
    @BsonProperty
    private String subject;
    @BsonProperty
    private int maxAge;
    @BsonProperty
    private double bonus;
}
