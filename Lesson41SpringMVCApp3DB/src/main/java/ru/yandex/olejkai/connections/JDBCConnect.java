package ru.yandex.olejkai.connections;

import java.sql.*;
import java.lang.Class;

public class JDBCConnect implements Connectivity {
    private final String PATH = "jdbc:postgresql://localhost:5432/first_db";
    private final String USR = "postgres";
    private final String PASS = "pa44w0rd";

    public Connection conn;
    public Statement s;

    public Statement connectQuery(String query){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(PATH, USR, PASS);
            s=conn.prepareStatement(query);

        } catch (ClassNotFoundException | SQLException e) {
            try { conn.close(); } catch (Exception ee) {  }
            try { s.close(); } catch (Exception ee) {  }
            e.printStackTrace();
        }

        return s;

    }



    }



