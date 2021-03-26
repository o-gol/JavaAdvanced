<%--
  Created by IntelliJ IDEA.
  User: o.goluzov
  Date: 17.03.2021
  Time: 1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SecondJsp</title>
</head>
<body>
<h1>Second JSP</h1>
<%
    String name = request.getParameter("name");
    out.println(String.format("Hello-%s",name));
    response.sendRedirect(String.format("/hello_world?name=%s",name));

%>
</body>
</html>
