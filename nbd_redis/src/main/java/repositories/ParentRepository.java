package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entity.UniqueId;
import model.Parent;
import org.bson.conversions.Bson;

public class ParentRepository extends AbstractRepository implements Repository<Parent, UniqueId>{
    MongoCollection<Parent> parentMongoCollection = mongoDatabase.getCollection("parents", Parent.class);
    //C
    @Override
    public Parent add(Parent item) {
        parentMongoCollection.insertOne(item);
        return item;
    }
    //R
    @Override
    public Parent get(Parent item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        return parentMongoCollection.find(filter).first();
    }

    public Parent getByEntityId(UniqueId entityId){
        Bson filter = Filters.eq("_id", entityId.getUuid());
        return parentMongoCollection.find(filter).first();
    }
    //U
    @Override
    public void update(Parent item1) {
        Bson filter = Filters.eq("_id", item1.getEntityId().getUuid());
        Bson update = Updates.combine(
                Updates.set("name", item1.getName()),
                Updates.set("address", item1.getAddress()),
                Updates.set("phone_number", item1.getPhoneNumber()),
                Updates.set("child_age", item1.getChildAge())
        );
        parentMongoCollection.updateOne(filter, update);
    }
    //D
    @Override
    public void remove(Parent item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        parentMongoCollection.findOneAndDelete(filter);
    }

    public long getCollectionSize() {
        return parentMongoCollection.countDocuments();
    }
}