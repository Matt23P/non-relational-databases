package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entity.UniqueId;
import model.Reservation;
import org.bson.conversions.Bson;

public class ReservationRepository extends AbstractRepository implements Repository<Reservation, Long>{

    MongoCollection<Reservation> reservationMongoCollection = mongoDatabase.getCollection("reservations", Reservation.class);
    //C
    @Override
    public Reservation add(Reservation item) {
        reservationMongoCollection.insertOne(item);
        return item;
    }
    //R
    @Override
    public Reservation get(Reservation item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        return reservationMongoCollection.find(filter).first();
    }

    public Reservation getByEntityId(UniqueId entityId){
        Bson filter = Filters.eq("_id", entityId.getUuid());
        return reservationMongoCollection.find(filter).first();
    }
    //U
    @Override
    public void update(Reservation item1) {
        Bson filter = Filters.eq("_id", item1.getEntityId().getUuid());
        Bson update = Updates.combine(
                Updates.set("date", item1.getDate()),
                Updates.set("start_hour", item1.getStartTime()),
                Updates.set("end_hour", item1.getEndTime()),
                Updates.set("parent", item1.getParent()),
                Updates.set("sitter", item1.getSitter())
        );
        reservationMongoCollection.updateOne(filter, update);
    }
    //D
    @Override
    public void remove(Reservation item) {
        Bson filter = Filters.eq("_id", item.getEntityId().getUuid());
        reservationMongoCollection.findOneAndDelete(filter);
    }

    public long getCollectionSize() {
        return reservationMongoCollection.countDocuments();
    }
}
