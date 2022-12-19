package entity;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.NonNull;
import org.bson.codecs.pojo.annotations.BsonId;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    @NonNull
    @PartitionKey
    @CqlName("ID")
    private final UniqueId entityId;

    public UniqueId getEntityId() {
        return entityId;
    }

    public AbstractEntity(UniqueId entityId) {
        this.entityId = entityId;
    }

}
