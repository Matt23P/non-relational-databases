package dao;

import com.datastax.oss.driver.api.mapper.annotations.*;
import model.Parent;

import java.sql.ResultSet;

@Dao
public interface ParentDao {

    @Insert
    void createParent(Parent parent);

    @GetEntity
    Parent readParent(ResultSet resultSet);

    @Update
    void updateParent (Parent parent);

    @Delete
    void deleteParent (Parent parent);
}
