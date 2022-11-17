package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entity.UniqueIdMgd;
import model.ParentMgd;
import org.bson.conversions.Bson;

public class ParentRepositoryMgd extends AbstractRepositoryMgd implements RepositoryMgd<ParentMgd, UniqueIdMgd>{
    MongoCollection<ParentMgd> parentMgdMongoCollection = mongoDatabase.getCollection("parents", ParentMgd.class);
//C
    @Override
    public ParentMgd add(ParentMgd item) {
        parentMgdMongoCollection.insertOne(item);
        return item;
    }
//R
    @Override
    public ParentMgd get(ParentMgd item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        return parentMgdMongoCollection.find(filter).first();
    }

    public ParentMgd getByEntityId(UniqueIdMgd entityId){
        Bson filter = Filters.eq("_id", entityId.getUuid());
        return parentMgdMongoCollection.find(filter).first();
    }
//U
    @Override
    public void update(ParentMgd item1) {
        Bson filter = Filters.eq("_id", item1.getEntityId().getUuid());
        Bson update = Updates.combine(
                Updates.set("name", item1.getName()),
                Updates.set("address", item1.getAddress()),
                Updates.set("phone_number", item1.getPhoneNumber()),
                Updates.set("child_age", item1.getChildAge())
        );
        parentMgdMongoCollection.updateOne(filter, update);
    }
//D
    @Override
    public void remove(ParentMgd item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        parentMgdMongoCollection.findOneAndDelete(filter);
    }

    public long getCollectionSize() {
        return parentMgdMongoCollection.countDocuments();
    }
}
