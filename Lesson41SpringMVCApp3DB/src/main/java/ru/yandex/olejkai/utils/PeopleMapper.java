package ru.yandex.olejkai.utils;

//import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapper;
import ru.yandex.olejkai.connections.JDBCConnect;
import ru.yandex.olejkai.model.People;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleMapper implements RowMapper<People> {

    @Override
    public People mapRow(ResultSet rs, int rowNum) throws SQLException {
        return JDBCConnect.getPeopleFromResultSet(rs);
    }


}
