package repositories;


import java.net.InetSocketAddress;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.oss.driver.api.querybuilder.schema.CreateKeyspace;

import static com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createKeyspace;
import static entity.CassandraNamespaces.*;

public abstract class AbstractRepository {
    private static CqlSession session;

    public void initSession() {
        session = CqlSession.builder().addContactPoint(new InetSocketAddress("cassandra1", 9042))
                .addContactPoint(new InetSocketAddress("cassandra2", 9043))
                .withLocalDatacenter("dc1")
                .withAuthCredentials("cassandra", "cassandrapassword")
                .withKeyspace(CqlIdentifier.fromCql("sitter"))
                .build();

        CreateKeyspace keyspace = createKeyspace(SITTER_NAMESPACE)
                .ifNotExists()
                .withSimpleStrategy(2)
                .withDurableWrites(true);
        SimpleStatement createKeyspace = keyspace.build();
        session.execute(createKeyspace);

        SimpleStatement createParents = SchemaBuilder.createTable(PARENT_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("ID"), DataTypes.UUID)
                .withColumn(CqlIdentifier.fromCql("name"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("address"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("phoneNumber"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("childAge"), DataTypes.INT)
                .build();
        session.execute(createParents);

        SimpleStatement createSitters = SchemaBuilder.createTable(SITTER_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("ID"), DataTypes.UUID)
                .withColumn(CqlIdentifier.fromCql("firstName"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("lastName"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("sitterType"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("basePrice"), DataTypes.DOUBLE)
                .withColumn(CqlIdentifier.fromCql("skill"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("minAge"), DataTypes.INT)
                .withColumn(CqlIdentifier.fromCql("available"), DataTypes.BOOLEAN)
                .build();
        session.execute(createSitters);

        SimpleStatement createReservations = SchemaBuilder.createTable(RESERVATION_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("ID"), DataTypes.UUID)
                .withColumn(CqlIdentifier.fromCql("date"), DataTypes.DATE)
                .withColumn(CqlIdentifier.fromCql("startTime"), DataTypes.TIME)
                .withColumn(CqlIdentifier.fromCql("endTime"), DataTypes.TIME)
                .withColumn(CqlIdentifier.fromCql("parent"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("sitter"), DataTypes.TEXT)
                .build();
        session.execute(createReservations);
    }
}