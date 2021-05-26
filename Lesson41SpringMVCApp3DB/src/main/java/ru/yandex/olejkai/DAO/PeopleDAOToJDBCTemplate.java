package ru.yandex.olejkai.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import ru.yandex.olejkai.model.People;
import ru.yandex.olejkai.utils.PeopleMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Qualifier("jdbcTemplate")
public class PeopleDAOToJDBCTemplate implements PeopleDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public PeopleDAOToJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addPeople(People people) {
        if (people.getId() == 0 ) {
//        if (people.getId() == 0 || people.getId() < People.getGlobId()) {
            People.setGlobId(getMaxId());
            int id = People.getGlobId() + 1;
            People.setGlobId(id);
            people.setId(id);

        }
        jdbcTemplate.update("INSERT INTO people values (?,?,?,?,?)",people.getId(),people.getName(),people.getSurName(),people.getEmail(),people.getAge());

    }

    @Override
    public void deletePeople(People people) {

    }

    @Override
    public People getPeople(People people) {
        return null;
    }

    @Override
    public People getPeopleByID(int id) {
//        return jdbcTemplate.query("select * from people where id=?",new Object[]{id}, new PeopleMapper())
        return jdbcTemplate.query("select * from people where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(People.class))
                .stream()
                .findAny()
                .orElse(null);

    }

    @Override
    public void deletePeopleByID(int id) {
        jdbcTemplate.update("DELETE FROM people WHERE id=?",id);

    }

    @Override
    public List<People> getAllPeople() {
        return jdbcTemplate.query("select * from people", new BeanPropertyRowMapper<>(People.class));
//        return jdbcTemplate.query("select * from people",new PeopleMapper());
    }

    @Override
    public void updatePeople(People peopleForUpdate, People peopleFromUpdate) {
        jdbcTemplate.update("UPDATE people SET name=?, surname=?, email=?, age=? WHERE id=?"
                ,peopleFromUpdate.getName()
                ,peopleFromUpdate.getSurName()
                ,peopleFromUpdate.getEmail()
                ,peopleFromUpdate.getAge()
                ,peopleForUpdate.getId()
                );
    }

    @Override
    public int getMaxId() {

//        return jdbcTemplate.queryForObject("SELECT MAX(id) FROM people",Integer.class);

        return jdbcTemplate.query("SELECT MAX(id) FROM people", rs -> {

                if (rs == null)
                    return 0;
                else {
                    rs.next();
                    return rs.getInt("max");
                }

        });
    }


}
