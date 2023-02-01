package model;

import entity.UniqueId;
import org.bson.codecs.pojo.annotations.BsonId;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    @BsonId
    private final UniqueId entityId;

    public UniqueId getEntityId() {
        return entityId;
    }

    public AbstractEntity(UniqueId entityId) {
        this.entityId = entityId;
    }
}
