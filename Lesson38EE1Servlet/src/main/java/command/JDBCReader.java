package command;

import java.sql.*;

public class JDBCReader {
    final static String jdbcDriver=
            "com.mysql.jdbc.Driver";
    final static String CONNECTION_STRING=
            "jdbc:mysql://127.0.0.1:3306/wed?user=root&password=pa$$w0rd&useSSL=false";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        Statement statement = connection.createStatement();
//            ResultSet rs=statement.executeQuery("SELECT name from teachers");
        ResultSet rs=statement.executeQuery("SELECT * from teachers");
        while (rs.next()){
//                writer.println(rs.getArray("teachers"));
            System.out.println(rs.getString("phone"));
            System.out.println(rs.getString("name"));
        }

        rs.close();
        connection.close();

    }

}
