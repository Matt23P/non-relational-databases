package model;

import entity.UniqueIdMgd;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@Setter
public class HousekeeperMgd extends SitterMgd {
    @BsonCreator
    public HousekeeperMgd(@BsonId UniqueIdMgd entityId,
                          @BsonProperty("first_name") String firstName,
                          @BsonProperty("last_name") String lastName,
                          @BsonProperty("base_price") double basePrice,
                          @BsonProperty("skill") String skill) {
        super(entityId, firstName, lastName, basePrice, true);
        this.skill = skill;
    }

    public HousekeeperMgd(
            String firstName,
            String lastName,
            double basePrice,
            String skill) {
        super(new UniqueIdMgd(), firstName, lastName, basePrice, true);
        this.skill = skill;
    }

    @BsonProperty
    private String skill;
}
