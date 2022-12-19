package entity;

import com.datastax.oss.driver.api.core.CqlIdentifier;

public class CassandraNamespaces {
    public static final CqlIdentifier SITTER_NAMESPACE = CqlIdentifier.fromCql("sitter");
    public static final CqlIdentifier PARENT_ID = CqlIdentifier.fromCql("parents_id");
    public static final CqlIdentifier SITTER_ID = CqlIdentifier.fromCql("sitters_id");
    public static final CqlIdentifier RESERVATION_ID = CqlIdentifier.fromCql("reservations_id");

}
