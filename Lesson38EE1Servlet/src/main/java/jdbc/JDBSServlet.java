package jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class JDBSServlet extends HttpServlet {
    final static String CONNECTION_STRING=
            "jdbc:mysql://127.0.0.1:3306/wed?user=root&password=pa$$w0rd&useSSL=false";
    Connection connection;
    ResultSet rs;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer=resp.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            writer.println("    <title>JDBCServlet</title>");
            writer.println("</head>");
            Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection
                    (CONNECTION_STRING);
            Statement statement = connection.createStatement();
//            ResultSet rs=statement.executeQuery("SELECT name from teachers");
            rs=statement.executeQuery("SELECT * from teachers");
            while (rs.next()){
//                writer.println(rs.getArray("teachers"));
                writer.println("<h3>"+rs.getString("phone")+"</h3>");
                writer.println("<h3>"+rs.getString("name")+"</h3>");
                System.out.println(rs.getString("name"));
            }
            writer.println("</html>");
            rs.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
