package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.junit.platform.engine.UniqueId;
import org.hibernate.annotations.NamedQuery;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Embedded
    @NotNull
    private UniqueId abstractEntityId;

    @Version
    @NotEmpty
    private long version;

    protected AbstractEntity(){

    }
}
