import com.sun.tools.javac.util.List;

public abstract class AbstractMongoRepository implements AutoCloseable {
    private ConnectionString connectionString = new ConnectionString("mongo://localhost:27017");
    private MongoCredential credential = MongoCredential.createCredential("admin","admin","adminpassword".toCharArray());
    private CodeRegistry pojoCodecRegistry =
            CodecRegistries.fromProviders(PojoCodecProvier.builder()
                    .automatic(true)
                    .conventions(List.of(Conventions.ANNOTATION_CONVENTION))
                    .build());
    private MongoClient mongoClient;
    private MongoDatabase rentACarDB; //rentACarDB thats from lecture xd
}
