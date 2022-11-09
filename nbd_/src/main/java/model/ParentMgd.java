package model;

import entity.AbstractEntityMgd;
import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class ParentMgd extends AbstractEntityMgd {
    @BsonCreator
    public ParentMgd(@BsonProperty("_id") UniqueIdMgd entityId,
                     @BsonProperty("name") String name,
                     @BsonProperty("address") String address,
                     @BsonProperty("phonenumber") String phoneNumber) {
        super(entityId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @BsonProperty
    private String name;
    @BsonProperty
    private String address;
    @BsonProperty
    private String phoneNumber;
}
