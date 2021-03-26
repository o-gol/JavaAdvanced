package сookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        String id=null;
        String pass = null;
        String JSESSIONID=null;
        for (Cookie cookie :
                cookies) {
            String name = cookie.getName();
            if ("id".equals(name)) {
                id = cookie.getValue();
            } else if ("pass".equals(name)) {
                pass = cookie.getValue();
            } else if ("JSESSIONID".equals(name)) {
                JSESSIONID = cookie.getValue();
            }
        }

        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        writer.printf("<h2>id=%s,pass=%s,JSESSIONID=%s</h3>\n",id,pass,JSESSIONID);
        writer.println("</html>");





    }
}
