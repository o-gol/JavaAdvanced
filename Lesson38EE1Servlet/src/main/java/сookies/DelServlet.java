package сookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        Cookie cookieId;
        Cookie cookiePass;

        for (Cookie cookie :
                cookies) {
            String name = cookie.getName();
            if ("id".equals(name)) {
                cookieId = new Cookie(cookie.getName(), "");
                cookieId.setMaxAge(0);
                response.addCookie(cookieId);
            } else if ("pass".equals(name)) {
                cookiePass = new Cookie(cookie.getName(), "");
                cookiePass.setMaxAge(0);
                response.addCookie(cookiePass);
            }
        }

    }
}
