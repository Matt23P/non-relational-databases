package repositories;

import entity.UniqueIdMgd;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class EntityMgd {
    public EntityMgd(@BsonId UniqueIdMgd entityId, @BsonProperty String name){
        this.entityId = entityId;
        this.name = name;
    }

    public UniqueIdMgd getEntityId(){
        return entityId;
    }

    public String getName(){
        return name;
    }
    @BsonId
    private UniqueIdMgd entityId;
    @BsonProperty
    private String name;
}
