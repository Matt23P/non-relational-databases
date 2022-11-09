package model;

import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class HousekeeperMgd extends SitterMgd {
    @BsonCreator
    public HousekeeperMgd(@BsonProperty UniqueIdMgd entityId,
                          @BsonProperty String firstName,
                          @BsonProperty String lastName,
                          @BsonProperty double basePrice,
                          @BsonProperty String skill) {
        super(entityId, firstName, lastName, basePrice);
        this.skill = skill;
    }

    @BsonProperty
    private String skill;
}
