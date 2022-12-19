package entity;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.NonNull;

import java.util.UUID;

public class UniqueId {

    @NonNull
    @PartitionKey
    @CqlName("ID")
    private UUID uuid;

    public UniqueId(UUID uuid) {
        this.uuid = uuid;
    }

    public UniqueId() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }


}
