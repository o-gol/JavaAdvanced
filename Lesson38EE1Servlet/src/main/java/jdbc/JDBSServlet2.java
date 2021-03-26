package jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "JDBSServlet2")
public class JDBSServlet2 extends HttpServlet {
    final static String CONNECTION_STRING=
            "jdbc:mysql://127.0.0.1:3306/wed?user=root&password=pa$$w0rd&useSSL=false";
    Connection connection;
    ResultSet rs;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer=response.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.printf("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            writer.println("    <title>JDBCServlet2</title>");
            writer.println("</head>");
            Class.forName("com.mysql.cj.jdbc.Driver");
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
