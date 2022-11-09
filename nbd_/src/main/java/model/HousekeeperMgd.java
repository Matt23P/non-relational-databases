package model;

import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class HousekeeperMgd extends SitterMgd {
    @BsonCreator
    public HousekeeperMgd(@BsonProperty("_id") UniqueIdMgd entityId,
                          @BsonProperty("first_name") String firstName,
                          @BsonProperty("last_name") String lastName,
                          @BsonProperty("base_price") double basePrice,
                          @BsonProperty("skill") String skill) {
        super(entityId, firstName, lastName, basePrice);
        this.skill = skill;
    }

    @BsonProperty
    private String skill;
}
