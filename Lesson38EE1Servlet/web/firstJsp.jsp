<%@ page import="java.util.Date" %>
<%@ page import="logic.TestClass" %>
<%--
  Created by IntelliJ IDEA.
  User: o.goluzov
  Date: 16.03.2021
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<h1>Test Jsp</h1>
<p>
    <%=new Date()%>
</p>
<%
    Date now=new Date();
    out.println(now);
%>
<p>

    <%= "Hello World\n "+now%>
    <%
        String name = request.getParameter("name");
    %>
</p>
<p>
    <%
        for (int i = 0; i < 5; i++) {
            out.println(String.format("<p>Hello!!</p>"));
        }

        out.println(String.format("<p>%s</p>",new TestClass().getInfo()));
        out.println(String.format("<p>%s</p>",name));

//        response.sendRedirect(String.format("/hello_world?name=%s",name));


    %>
</p>

</body>
</html>
