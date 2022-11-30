package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entity.UniqueId;
import model.Sitter;
import org.bson.conversions.Bson;

public class SitterRepository extends AbstractRepository implements Repository<Sitter>{
    MongoCollection<Sitter> sitterMongoCollection = mongoDatabase.getCollection("sitters", Sitter.class);

    //C
    @Override
    public Sitter add(Sitter item) {
        sitterMongoCollection.insertOne(item);
        return item;
    }
    //R
    @Override
    public Sitter get(Sitter item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        return sitterMongoCollection.find(filter).first();
    }

    public Sitter getByEntityId(UniqueId entityId){
        Bson filter = Filters.eq("_id", entityId.getUuid());
        return sitterMongoCollection.find(filter).first();
    }
    //U
    @Override
    public boolean update(Sitter item1) {
        Bson filter = Filters.eq("_id", item1.getEntityId().getUuid());
        Bson update = Updates.combine(
                Updates.set("first_name", item1.getFirstName()),
                Updates.set("last_name", item1.getLastName()),
                Updates.set("base_price", item1.getBasePrice()),
                Updates.set("skill", item1.getSkill()),
                Updates.set("min_age", item1.getMinAge()),
                Updates.set("is_available", item1.isAvailable())
        );
        sitterMongoCollection.updateOne(filter, update);
        return true;
    }
    //D
    @Override
    public void remove(Sitter item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        sitterMongoCollection.findOneAndDelete(filter);
    }

    public void setAvailable(Sitter item, boolean available){ item.setAvailable(available); }

    public boolean getAvailable(Sitter item){ return item.isAvailable(); }

    public long getCollectionSize() {
        return sitterMongoCollection.countDocuments();
    }
}
