package ru.yandex.olejkai.connections;

import java.sql.*;
import java.lang.Class;

public class JDBCConnect implements Connectivity {
    private final String PATH ;
    private final String USR ;
    private final String PASS;
    private final String CLASS_DRIVER;

    public JDBCConnect(String PATH, String USR, String PASS, String CLASS_DRIVER ) {
        this.PATH = PATH;
        this.USR = USR;
        this.PASS = PASS;
        this.CLASS_DRIVER=CLASS_DRIVER;
    }

    /*
    private final String PATH = "jdbc:postgresql://localhost:5432/first_db";
    private final String USR = "postgres";
    private final String PASS = "pa44w0rd";
*/

    public Connection conn;
    public Statement s;

    public Statement connectQuery(String query){
        try {
            Class.forName(CLASS_DRIVER);
//            Class.forName("org.postgresql.Driver");
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



