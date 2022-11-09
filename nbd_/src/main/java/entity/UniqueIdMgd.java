package entity;

import java.util.UUID;

public class UniqueIdMgd {
    private UUID uuid;

    public UniqueIdMgd(UUID uuid) {
        this.uuid = uuid;
    }

    public UniqueIdMgd() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }


}
