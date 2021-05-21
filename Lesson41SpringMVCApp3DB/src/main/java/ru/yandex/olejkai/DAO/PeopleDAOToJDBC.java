package ru.yandex.olejkai.DAO;

import ru.yandex.olejkai.connections.Connectivity;
import ru.yandex.olejkai.connections.JDBCConnect;
import ru.yandex.olejkai.model.People;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PeopleDAOToJDBC implements PeopleDAO {
    Connectivity connectivity;

    public PeopleDAOToJDBC(Connectivity connectivity) {
        this.connectivity = connectivity;
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
        JDBCConnect jdbcConnect = (JDBCConnect) connectivity;
        try {
            /*String query =String.format("INSERT INTO people values (%s,'%s','%s','%s',%s)",
                    people.getId(),
                    people.getName(),
                    people.getSurName(),
                    people.getEmail(),
                    people.getAge());
//            System.out.println(query);*/
            PreparedStatement ps= (PreparedStatement) jdbcConnect
                    .connectQuery("INSERT INTO people values (?,?,?,?,?)");
            ps.setInt(1,people.getId());
            ps.setString(2,people.getName());
            ps.setString(3,people.getSurName());
            ps.setString(4,people.getEmail());
            ps.setInt(5,people.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                jdbcConnect.s.close();
            } catch (Exception e) {
            }
            try {
                jdbcConnect.conn.close();
            } catch (Exception e) {
            }
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
        JDBCConnect jdbcConnect = (JDBCConnect) connectivity;
        People people = new People();
//        System.out.println(people);
//        List<Integer> list = new ArrayList<>();
//        List<People> list = new ArrayList<>();
        ResultSet rs = null;
        try {
//            rs = jdbcConnect.connectQuery().executeQuery("SELECT * FROM people");
            PreparedStatement ps=(PreparedStatement) jdbcConnect.connectQuery("SELECT * FROM people");
            rs = ps.executeQuery();
//            if(!rs.isBeforeFirst()) {

            while (rs.next()) {
//                People people = new People();
                if (rs.getInt("id") == id) {
                    people.setName(rs.getString("name"));
                    people.setId(rs.getInt("id"));
                    people.setSurName(rs.getString("surname"));
                    people.setEmail(rs.getString("email"));
                    people.setAge(rs.getInt("age"));
                    break;
                }
//                list.add(rs.getInt("id"));
            }
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                jdbcConnect.s.close();
            } catch (Exception e) {
            }
            try {
                jdbcConnect.conn.close();
            } catch (Exception e) {
            }
        }
        /*if (people.isEmpty())
            return null;
        else*/
            return people;
    }

    @Override
    public void deletePeopleByID(int id) {

        JDBCConnect jdbcConnect = (JDBCConnect) connectivity;
        try {
            /*String query =String.format("INSERT INTO people values (%s,'%s','%s','%s',%s)",
                    people.getId(),
                    people.getName(),
                    people.getSurName(),
                    people.getEmail(),
                    people.getAge());
//            System.out.println(query);*/
            PreparedStatement ps= (PreparedStatement) jdbcConnect
                    .connectQuery("DELETE FROM people WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                jdbcConnect.s.close();
            } catch (Exception e) {
            }
            try {
                jdbcConnect.conn.close();
            } catch (Exception e) {
            }
        }

    }


    @Override
    public List<People> getAllPeople() {
        JDBCConnect jdbcConnect = (JDBCConnect) connectivity;
        List<People> list = new ArrayList<>();
        ResultSet rs = null;
        try {
//            rs = jdbcConnect.connectQuery().executeQuery("SELECT * FROM people");
            PreparedStatement ps=(PreparedStatement) jdbcConnect.connectQuery("SELECT * FROM people");
            rs = ps.executeQuery();
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
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                jdbcConnect.s.close();
            } catch (Exception e) {
            }
            try {
                jdbcConnect.conn.close();
            } catch (Exception e) {
            }
        }

        return list.stream().sorted(Comparator.comparingInt(People::getId)).collect(Collectors.toList());
    }

    @Override
    public void updatePeople(People peopleForUpdate, People peopleFromUpdate) {
        /*deletePeopleByID(peopleForUpdate.getId());
        addPeople(peopleFromUpdate);*/
        JDBCConnect jdbcConnect = (JDBCConnect) connectivity;
        try {
            /*String query =String.format("INSERT INTO people values (%s,'%s','%s','%s',%s)",
                    people.getId(),
                    people.getName(),
                    people.getSurName(),
                    people.getEmail(),
                    people.getAge());
//            System.out.println(query);*/
            PreparedStatement ps= (PreparedStatement) jdbcConnect
                    .connectQuery("UPDATE people SET name=?, surname=?, email=?, age=? WHERE id=?");
            ps.setInt(5,peopleForUpdate.getId());
            ps.setString(1,peopleFromUpdate.getName());
            ps.setString(2,peopleFromUpdate.getSurName());
            ps.setString(3,peopleFromUpdate.getEmail());
            ps.setInt(4,peopleFromUpdate.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                jdbcConnect.s.close();
            } catch (Exception e) {
            }
            try {
                jdbcConnect.conn.close();
            } catch (Exception e) {
            }
        }


    }

    @Override
    public int getMaxId() {
        JDBCConnect jdbcConnect = (JDBCConnect) connectivity;
        List<Integer> list = new ArrayList<>();
//        List<People> list = new ArrayList<>();
        ResultSet rs = null;
        try {
//            rs = jdbcConnect.connectQuery().executeQuery("SELECT id FROM people");
            PreparedStatement ps=(PreparedStatement) jdbcConnect.connectQuery("SELECT id FROM people");
            rs = ps.executeQuery();
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
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                jdbcConnect.s.close();
            } catch (Exception e) {
            }
            try {
                jdbcConnect.conn.close();
            } catch (Exception e) {
            }
        }
        if (list.isEmpty())
            return 0;
        else
            return Collections.max(list);
    }
}
