package сookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")!=null&&request.getParameter("pass")!=null) {
            String id = request.getParameter("id");
            String pass = request.getParameter("pass");
            Cookie cookie01 = new Cookie("id", id);
            cookie01.setMaxAge(24 * 24 * 24);
            Cookie cookie02 = new Cookie("pass", pass);
            cookie02.setMaxAge(24 * 24 * 24);
            Cookie[] cookies = {cookie01, cookie02};
            for (Cookie cookie :
                    cookies) {
                response.addCookie(cookie);
            }
        }
    }
}
