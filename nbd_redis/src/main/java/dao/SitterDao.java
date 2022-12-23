package dao;

import com.datastax.oss.driver.api.mapper.annotations.*;
import model.Sitter;

import java.sql.ResultSet;

@Dao
public interface SitterDao {

    @Insert
    void createSitter(Sitter sitter);

    @GetEntity
    Sitter readSitter(ResultSet resultSet);

    @Update
    void updateSitter(Sitter sitter);

    @Delete
    void deleteSitter(Sitter sitter);

}
