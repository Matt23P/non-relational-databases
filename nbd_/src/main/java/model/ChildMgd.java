package model;

import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class ChildMgd extends ParentMgd {
    @BsonCreator
    public ChildMgd(@BsonProperty("_id") UniqueIdMgd entityId,
                    @BsonProperty("name") String name,
                    @BsonProperty("address") String address,
                    @BsonProperty("phonenumber") String phoneNumber,
                    @BsonProperty("childname") String childName,
                    @BsonProperty("childage") int childAge) {
        super(entityId, name, address, phoneNumber);
        this.childName = childName;
        this.childAge = childAge;
    }

    @BsonProperty
    private String childName;

    @BsonProperty
    private int childAge;
}
