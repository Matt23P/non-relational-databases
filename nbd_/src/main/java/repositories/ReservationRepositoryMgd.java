package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entity.UniqueIdMgd;
import model.ReservationMgd;
import org.bson.conversions.Bson;

public class ReservationRepositoryMgd extends AbstractRepositoryMgd implements RepositoryMgd<ReservationMgd, Long>{

    MongoCollection<ReservationMgd> reservationMgdMongoCollection = mongoDatabase.getCollection("reservations", ReservationMgd.class);
//C
    @Override
    public ReservationMgd add(ReservationMgd item) {
        reservationMgdMongoCollection.insertOne(item);
        return item;
    }
//R
    @Override
    public ReservationMgd get(ReservationMgd item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        return reservationMgdMongoCollection.find(filter).first();
    }

    public ReservationMgd getByEntityId(UniqueIdMgd entityId){
        Bson filter = Filters.eq("_id", entityId.getUuid());
        return reservationMgdMongoCollection.find(filter).first();
    }
//U
    @Override
    public void update(ReservationMgd item1) {
        Bson filter = Filters.eq("_id", item1.getEntityId().getUuid());
        Bson update = Updates.combine(
                Updates.set("date", item1.getDate()),
                Updates.set("start_hour", item1.getStartTime()),
                Updates.set("end_hour", item1.getEndTime()),
                Updates.set("parent", item1.getParent()),
                Updates.set("sitter", item1.getSitter())
        );
        reservationMgdMongoCollection.updateOne(filter, update);
    }
//D
    @Override
    public void remove(ReservationMgd item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        reservationMgdMongoCollection.findOneAndDelete(filter);
    }

    public long getCollectionSize() {
        return reservationMgdMongoCollection.countDocuments();
    }
}
