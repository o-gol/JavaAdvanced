import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JDBSServlet2")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Integer countOfSession = (Integer) session.getAttribute("countOfSession");
        if (countOfSession==null){
            session.setAttribute("countOfSession",1);
            countOfSession=0;
        }else
            session.setAttribute("countOfSession",countOfSession+1);


        String name = request.getParameter("name");
        String quantity=(request.getParameter("quantity"));

        PrintWriter writer = response.getWriter();
        writer.printf("<html>\n<h3>hello_world</h3>\n<h3>%s</h3>\n<h3>You count is %s</h3>\n<h3>Cart with %s - %s</h3>\n<h3>ПРИВЕТ</h3>\n</html>",name,countOfSession,name,quantity);
//        response.sendRedirect(String.format("/firstJsp.jsp?name=%s",name));
    }
}
