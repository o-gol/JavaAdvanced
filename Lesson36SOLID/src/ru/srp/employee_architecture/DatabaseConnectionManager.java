package ru.srp.employee_architecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    String managerName;
    private java.sql.Connection connection;

    private static volatile DatabaseConnectionManager instance;

    private DatabaseConnectionManager(){

    }

    public static DatabaseConnectionManager getInstance() {
        DatabaseConnectionManager localInstance = instance;
        if (localInstance == null) {
            synchronized (DatabaseConnectionManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DatabaseConnectionManager();
                }
            }
        }
        return localInstance;
    }

    void connectionToDatabase() throws SQLException {
        java.sql.Connection connection = DriverManager.getConnection("DataBaseURL");
        System.out.printf("We connected to database\n");
    }

    Connection getConnectionObject(){
        return connection;
    }

    void disconnect() throws SQLException {
        connection.close();
        System.out.printf("We disconnected from database\n");
    }
}
