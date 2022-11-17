package model;

import entity.AbstractEntityMgd;
import entity.UniqueIdMgd;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
@Getter
@Setter
public class ParentMgd extends AbstractEntityMgd {
    @BsonCreator
    public ParentMgd(@BsonId UniqueIdMgd entityId,
                     @BsonProperty("name") String name,
                     @BsonProperty("address") String address,
                     @BsonProperty("phone_number") String phoneNumber,
                     @BsonProperty("child_age") Integer childAge) {
        super(entityId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.childAge = childAge;
    }

    public ParentMgd(String name, String address, String phoneNumber, Integer childAge) {
        super(new UniqueIdMgd());
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.childAge = childAge;
    }

    @BsonProperty("name")
    private String name;
    @BsonProperty("address")
    private String address;
    @BsonProperty("phone_number")
    private String phoneNumber;
    @BsonProperty("child_age")
    private Integer childAge;

}
