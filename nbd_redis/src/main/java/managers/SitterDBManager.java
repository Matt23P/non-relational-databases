package managers;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.oss.driver.api.querybuilder.schema.CreateKeyspace;

import java.net.InetSocketAddress;
import static entity.CassandraNamespaces.*;
import static com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createKeyspace;

public class SitterDBManager {
    private static CqlSession session;
    public static CqlSession initSession() {
        session = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("localhost", 9042))
                .addContactPoint(new InetSocketAddress("localhost", 9043))
                .withLocalDatacenter("dc1")
                .withAuthCredentials("cassandra", "cassanrapassword")
                .withKeyspace(CqlIdentifier.fromCql("sitter"))
                .build();

        CreateKeyspace keyspace = createKeyspace(SITTER_NAMESPACE)
                .ifNotExists()
                .withSimpleStrategy(2)
                .withDurableWrites(true);
        SimpleStatement createKeyspace = keyspace.build();
        session.execute(createKeyspace);

        SimpleStatement createParents = SchemaBuilder.createTable(PARENTS_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("parent_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("name"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("address"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("phoneNumber"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("childAge"), DataTypes.INT)
                .build();
        session.execute(createParents);

        SimpleStatement createSitters = SchemaBuilder.createTable(SITTERS_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("sitter_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("firstName"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("lastName"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("basePrice"), DataTypes.DOUBLE)
                .withColumn(CqlIdentifier.fromCql("skill"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("minAge"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("available"), DataTypes.BOOLEAN)
                .withColumn(CqlIdentifier.fromCql("sitterType"), DataTypes.TEXT)
                .build();
        session.execute(createSitters);

        SimpleStatement createReservations = SchemaBuilder.createTable(RESERVATIONS_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("reservation_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("parent_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("sitter_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("parent_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("date"), DataTypes.DATE)
                .withColumn(CqlIdentifier.fromCql("startTime"), DataTypes.TIME)
                .withColumn(CqlIdentifier.fromCql("endTime"), DataTypes.TIME)
                .build();
        session.execute(createReservations);

        return session;
    }
}
