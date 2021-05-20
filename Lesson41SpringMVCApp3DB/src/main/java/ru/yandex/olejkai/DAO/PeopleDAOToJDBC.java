package ru.yandex.olejkai.DAO;

import ru.yandex.olejkai.connections.Connectivity;
import ru.yandex.olejkai.connections.JDBCConnect;
import ru.yandex.olejkai.model.People;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeopleDAOToJDBC implements PeopleDAO {
    Connectivity connectivity;

    public PeopleDAOToJDBC(Connectivity connectivity) {
        this.connectivity = connectivity;
    }

    @Override
    public void addPeople(People people) {
//        if (people.getId() == 0 || people.getId() < People.getGlobId()) {
            People.setGlobId(getMaxId());
            int id=People.getGlobId()+1;
            People.setGlobId(id);
            people.setId(id);

//        }
        JDBCConnect jdbcConnect=(JDBCConnect)connectivity;
        try {
            jdbcConnect.connectQuery().executeUpdate(String.format("INSERT INTO people values (%s,'%s','%s','%s',%s)",
                    people.getId(),
                    people.getName(),
                    people.getSurName(),
                    people.getEmail(),
                    people.getAge()));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try { jdbcConnect.s.close(); } catch (Exception e) {  }
            try { jdbcConnect.conn.close(); } catch (Exception e) {  }
        }

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
        return null;
    }

    @Override
    public void deletePeopleByID(int id) {

    }



    @Override
    public  List<People> getAllPeople() {
        JDBCConnect jdbcConnect= (JDBCConnect) connectivity;
        List<People> list = new ArrayList<>();
        ResultSet rs=null;
        try {
            rs = jdbcConnect.connectQuery().executeQuery("SELECT * FROM people");
//            if(!rs.isBeforeFirst()) {
                while (rs.next()) {
                    People people = new People();
                    people.setId(rs.getInt("id"));
                    people.setName(rs.getString("name"));
                    people.setSurName(rs.getString("surname"));
                    people.setEmail(rs.getString("email"));
                    people.setAge(rs.getInt("age"));
                    list.add(people);
                }
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try { rs.close(); } catch (Exception e) {  }
            try { jdbcConnect.s.close(); } catch (Exception e) {  }
            try { jdbcConnect.conn.close(); } catch (Exception e) {  }
        }

        return list;
    }

    @Override
    public void updatePeople( People peopleForUpdate, People peopleFromUpdate) {

    }

    @Override
    public int getMaxId() {
        JDBCConnect jdbcConnect= (JDBCConnect) connectivity;
        List<Integer> list=new ArrayList<>();
//        List<People> list = new ArrayList<>();
        ResultSet rs=null;
        try {
            rs = jdbcConnect.connectQuery().executeQuery("SELECT id FROM people");
//            if(!rs.isBeforeFirst()) {

            while (rs.next()) {
                /*People people = new People();
                people.setId(rs.getInt("id"));
                people.setName(rs.getString("name"));
                people.setSurName(rs.getString("surname"));
                people.setEmail(rs.getString("email"));
                people.setAge(rs.getInt("age"));*/
                list.add(rs.getInt("id"));
            }
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try { rs.close(); } catch (Exception e) {  }
            try { jdbcConnect.s.close(); } catch (Exception e) {  }
            try { jdbcConnect.conn.close(); } catch (Exception e) {  }
        }
        return Collections.max(list);
    }
}
