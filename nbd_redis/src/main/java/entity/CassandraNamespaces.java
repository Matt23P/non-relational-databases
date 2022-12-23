package entity;

import com.datastax.oss.driver.api.core.CqlIdentifier;

public class CassandraNamespaces {
    public static final CqlIdentifier SITTER_NAMESPACE = CqlIdentifier.fromCql("sitter");
    public static final CqlIdentifier PARENTS_ID = CqlIdentifier.fromCql("parents_id");
        public static final CqlIdentifier PARENT_ID = CqlIdentifier.fromCql("parent_id");
        public static final CqlIdentifier NAME = CqlIdentifier.fromCql("name");

        public static final CqlIdentifier ADDRESS = CqlIdentifier.fromCql("address");
        public static final CqlIdentifier PHONENUMBER = CqlIdentifier.fromCql("phoneNumber");
        public static final CqlIdentifier CHILDAGE = CqlIdentifier.fromCql("childAge");

    public static final CqlIdentifier SITTERS_ID = CqlIdentifier.fromCql("sitters_id");
        public static final CqlIdentifier SITTER_ID = CqlIdentifier.fromCql("sitter_id");
        public static final CqlIdentifier FIRSTNAME = CqlIdentifier.fromCql("firstName");
        public static final CqlIdentifier LASTNAME  = CqlIdentifier.fromCql("lastName");
        public static final CqlIdentifier BASEPRICE = CqlIdentifier.fromCql("basePrice");
        public static final CqlIdentifier SKILL = CqlIdentifier.fromCql("skill");
        public static final CqlIdentifier MINAGE = CqlIdentifier.fromCql("minAge");
        public static final CqlIdentifier AVAILABLE = CqlIdentifier.fromCql("available");
        public static final CqlIdentifier SITTERTYPE = CqlIdentifier.fromCql("sitterType");

    public static final CqlIdentifier RESERVATIONS_ID = CqlIdentifier.fromCql("reservations_id");
        public static final CqlIdentifier RESERVATION_ID = CqlIdentifier.fromCql("reservation_id");
        public static final CqlIdentifier DATE = CqlIdentifier.fromCql("date");
        public static final CqlIdentifier STARTTIME = CqlIdentifier.fromCql("startTime");
        public static final CqlIdentifier ENDTIME = CqlIdentifier.fromCql("endTime");

}
