package repositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import entity.UniqueIdCodecProvider;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;


public class AbstractRepositoryMgd {
    private ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
    private final MongoCredential credential = MongoCredential.createCredential("admin", "admin", "adminp".toCharArray());
    private final CodecRegistry pojoCodecRegistry =
            CodecRegistries.fromProviders(PojoCodecProvider.builder()
                    .automatic(true)
                    .conventions(List.of(Conventions.ANNOTATION_CONVENTION))
                    .build());


    protected MongoClientSettings clientSettings = MongoClientSettings.builder()
            .credential(credential)
            .applyConnectionString(connectionString)
            .uuidRepresentation(UuidRepresentation.STANDARD)
            .codecRegistry(CodecRegistries.fromRegistries(
                    CodecRegistries.fromProviders(new UniqueIdCodecProvider()),
                    MongoClientSettings.getDefaultCodecRegistry(),
                    pojoCodecRegistry
            )).build();

    protected final MongoClient mongoClient = MongoClients.create(clientSettings);
    protected final MongoDatabase mongoDatabase = mongoClient.getDatabase("SITTER");
}
