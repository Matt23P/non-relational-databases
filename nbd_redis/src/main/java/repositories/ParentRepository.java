package repositories;


import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import model.Parent;

public class ParentRepository extends AbstractRepository<Parent> implements Repository<Parent>{
    public ParentRepository(CqlSession session) {
        super(session);
    }

    @Override
    protected Parent rowToEntity(Row row){
        return

    }

}