<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: o.goluzov
  Date: 22.03.2021
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDBC</title>
</head>
<body>
<%
    final  String CONNECTION_STRING=
            "jdbc:mysql://127.0.0.1:3306/wed?user=root&password=pa$$w0rd&useSSL=false";
    try {
//            Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection
                (CONNECTION_STRING);
        Statement statement = connection.createStatement();
//            ResultSet rs=statement.executeQuery("SELECT name from teachers");
        ResultSet rs=statement.executeQuery("SELECT * from teachers");
        while (rs.next()){
            out.println(rs.getString("phone"));
            out.println("<h3>"+rs.getString("name")+"</h3>");
//
        }
        rs.close();
        connection.close();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }


%>
</body>
</html>
