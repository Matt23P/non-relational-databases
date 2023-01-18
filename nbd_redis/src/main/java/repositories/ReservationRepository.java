package repositories;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import entity.CassandraNamespaces;
import model.Reservation;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;

public class ReservationRepository extends AbstractRepository<Reservation> implements Repository<Reservation> {

    public ReservationRepository(CqlSession session) {
        super(session);
    }

    @Override
    protected Reservation rowToEntity(Row row) {
        return new Reservation(
                row.getString(CassandraNamespaces.RESERVATION_ID),
                row.getString(CassandraNamespaces.PARENT_ID),
                row.getString(CassandraNamespaces.SITTER_ID),
                row.getLocalDate(CassandraNamespaces.DATE),
                row.getLocalTime(CassandraNamespaces.STARTTIME),
                row.getLocalTime(CassandraNamespaces.ENDTIME)
        );
    }

    @Override
    public Reservation get(Object element) {
        Select getReservationByID = QueryBuilder.selectFrom(CassandraNamespaces.RESERVATIONS_ID).all()
                .where(Relation.column("reservation_id").isEqualTo(bindMarker()));
        PreparedStatement preparedStatement = session.prepare(getReservationByID.build());
        return Optional.ofNullable(readReservation((ResultSet) session.execute(preparedStatement.bind(element)))).orElseThrow();
    }

    @Override
    public void add(Reservation... elements) {
        Stream.of(elements).forEach(this::createReservation);
    }

    @Override
    public void remove(Reservation... elements) {
        Stream.of(elements).forEach(this::deleteReservation);
    }

    @Override
    public void update(Reservation... elements) {
        Stream.of(elements).forEach(this::updateReservation);
    }

    @Override
    public List<Reservation> find(Object... elements) {
        Select getReservationByID = QueryBuilder.selectFrom(CassandraNamespaces.RESERVATIONS_ID).all();
        Stream.of(elements).forEach(element -> getReservationByID.where(Relation.column("reservation_id").isEqualTo(bindMarker())));
        PreparedStatement preparedStatement = session.prepare(getReservationByID.build());
        return session.execute(preparedStatement.bind(elements)).all().stream().map(this::rowToEntity).collect(Collectors.toList());
    }

    @Override
    public List<Reservation> getAll() {
        Select getReservations = QueryBuilder.selectFrom(CassandraNamespaces.RESERVATIONS_ID).all();
        return session.execute(getReservations.build()).all().stream().map(this::rowToEntity).collect(Collectors.toList());
    }


}
