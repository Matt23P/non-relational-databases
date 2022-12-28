package repositories;


import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import entity.CassandraNamespaces;
import model.Parent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;

public class ParentRepository extends AbstractRepository<Parent> implements Repository<Parent> {
    public ParentRepository(CqlSession session) {
        super(session);
    }

    @Override
    protected Parent rowToEntity(Row row) {
        return new Parent(row.getString(CassandraNamespaces.PARENT_ID),
                Objects.requireNonNull(row.getString(CassandraNamespaces.NAME)),
                Objects.requireNonNull(row.getString(CassandraNamespaces.ADDRESS)),
                Objects.requireNonNull(row.getString(CassandraNamespaces.PHONENUMBER)),
                Objects.requireNonNull(row.getInt(CassandraNamespaces.CHILDAGE)));
    }

    @Override
    public Parent get(Object element) {
        Select getParentByPersonalID = QueryBuilder.selectFrom(CassandraNamespaces.PARENTS_ID)
                .all()
                .where(Relation.column("parent_id").isEqualTo(literal(element.toString())));
        return Optional.ofNullable(readParent((ResultSet) session.execute(getParentByPersonalID.build()))).orElseThrow();
    }

    @Override
    public void add(Parent... elements) {
        Stream.of(elements).forEach(this::createParent);
    }

    @Override
    public void remove(Parent... elements) {
        Stream.of(elements).forEach(this::deleteParent);
    }

    @Override
    public void update(Parent... elements) {
        Stream.of(elements).forEach(this::updateParent);
    }

    @Override
    public List<Parent> find(Object... elements) {
        Select getParentsByPersonalID = QueryBuilder.selectFrom(CassandraNamespaces.PARENTS_ID).all();
        Stream.of(elements).forEach(element -> getParentsByPersonalID.where(Relation.column("parent_id")
                .isEqualTo(literal(element.toString()))));
        return session.execute(getParentsByPersonalID.build()).all().stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Parent> getAll() {
        Select getParentsByPersonalID = QueryBuilder.selectFrom(CassandraNamespaces.PARENTS_ID).all();
        return session.execute(getParentsByPersonalID.build()).all().stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }
}