package entity;

import java.util.UUID;

public class UniqueId {
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
