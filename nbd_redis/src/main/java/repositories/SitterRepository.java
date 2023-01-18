package repositories;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import entity.CassandraNamespaces;
import model.Sitter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;


public class SitterRepository extends AbstractRepository<Sitter> implements Repository<Sitter> {
    public SitterRepository(CqlSession session) {
        super(session);
    }

    @Override
    protected Sitter rowToEntity(Row row) {
        return new Sitter(row.getString(CassandraNamespaces.SITTER_ID),
                row.getString(CassandraNamespaces.FIRSTNAME),
                row.getString(CassandraNamespaces.LASTNAME),
                row.getDouble(CassandraNamespaces.BASEPRICE),
                row.getString(CassandraNamespaces.SKILL),
                row.getInt(CassandraNamespaces.MINAGE),
                row.getBoolean(CassandraNamespaces.AVAILABLE),
                row.getString(CassandraNamespaces.SITTERTYPE));
    }

    @Override
    public Sitter get(Object element) {
        Select getSitterByID = QueryBuilder.selectFrom(CassandraNamespaces.SITTERS_ID).all()
                .where(Relation.column("sitter_id").isEqualTo(bindMarker()));
        PreparedStatement preparedStatement = session.prepare(getSitterByID.build());
        return Optional.ofNullable(readSitter((ResultSet) session.execute(preparedStatement.bind(element)))).orElseThrow();
    }

    @Override
    public void add(Sitter... elements) {
        Stream.of(elements).forEach(this::createSitter);
    }

    @Override
    public void remove(Sitter... elements) {
        Stream.of(elements).forEach(this::deleteSitter);
    }

    @Override
    public void update(Sitter... elements) {
        Stream.of(elements).forEach(this::updateSitter);
    }

    @Override
    public List<Sitter> find(Object... elements) {
        Select getSitterByID = QueryBuilder.selectFrom(CassandraNamespaces.SITTERS_ID).all();
        Stream.of(elements).forEach(element -> getSitterByID.where(Relation.column("sitter_id").isEqualTo(bindMarker())));
        PreparedStatement preparedStatement = session.prepare(getSitterByID.build());
        return session.execute(preparedStatement.bind(elements)).all().stream().map(this::rowToEntity).collect(Collectors.toList());
    }

    @Override
    public List<Sitter> getAll() {
        Select getSitters = QueryBuilder.selectFrom(CassandraNamespaces.SITTERS_ID).all();
        return session.execute(getSitters.build()).all().stream().map(this::rowToEntity).collect(Collectors.toList());
    }
}
