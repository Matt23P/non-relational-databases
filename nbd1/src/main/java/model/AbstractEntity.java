package model;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Version
    private long version;

    protected AbstractEntity() {

    }
}
