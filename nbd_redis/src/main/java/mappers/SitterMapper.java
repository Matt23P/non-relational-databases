package mappers;


import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.DaoTable;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import dao.SitterDao;

@Mapper
public interface SitterMapper {
    @DaoFactory
    SitterDao sitterDao(@DaoKeyspace String keyspace,
                        @DaoTable String table);

    @DaoFactory
    SitterDao sitterDao();
}
