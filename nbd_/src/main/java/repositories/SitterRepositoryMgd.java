package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entity.UniqueIdMgd;
import model.SitterMgd;
import org.bson.conversions.Bson;

public class SitterRepositoryMgd extends AbstractRepositoryMgd implements RepositoryMgd<SitterMgd, Long>{
    MongoCollection<SitterMgd> sitterMgdMongoCollection = mongoDatabase.getCollection("sitters", SitterMgd.class);

//C
    @Override
    public SitterMgd add(SitterMgd item) {
        sitterMgdMongoCollection.insertOne(item);
        return item;
    }
//R
    @Override
    public SitterMgd get(SitterMgd item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        return sitterMgdMongoCollection.find(filter).first();
    }

    public SitterMgd getByEntityId(UniqueIdMgd entityId){
        Bson filter = Filters.eq("_id", entityId.getUuid());
        return sitterMgdMongoCollection.find(filter).first();
    }
//U
    @Override
    public void update(SitterMgd item1) {
        Bson filter = Filters.eq("_id", item1.getEntityId().getUuid());
        Bson update = Updates.combine(
                Updates.set("first_name", item1.getFirstName()),
                Updates.set("last_name", item1.getLastName()),
                Updates.set("sitter_type", item1.getSitterType()),
                Updates.set("base_price", item1.getBasePrice()),
                Updates.set("skill", item1.getSkill()),
                Updates.set("min_age", item1.getMinAge()),
                Updates.set("is_available", item1.getIsAvailable())
        );
    }
//D
    @Override
    public void remove(SitterMgd item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        sitterMgdMongoCollection.findOneAndDelete(filter);
    }

    public void setAvailable(SitterMgd item, boolean available){ item.setAvailable(available); }

    public boolean getAvailable(SitterMgd item){ return item.getIsAvailable(); }

    public long getCollectionSize() {
        return sitterMgdMongoCollection.countDocuments();
    }
}
