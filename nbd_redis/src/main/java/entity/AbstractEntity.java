package entity;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    @BsonId //JsonbId nie ma czegos takiego
    private final UniqueId entityId;

    public UniqueId getEntityId() {
        return entityId;
    }

    public AbstractEntity(UniqueId entityId) {
        this.entityId = entityId;
    }
}
