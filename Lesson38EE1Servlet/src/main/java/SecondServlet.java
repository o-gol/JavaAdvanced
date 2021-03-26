import data.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SecondServlet")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String quantity=(request.getParameter("quantity"));
        HttpSession session=request.getSession();
        Cart cart=(Cart)session.getAttribute("cart");
        if(cart==null)
        {
            cart=new Cart();
        }
        cart = nullCheck(name, quantity, session, cart);


        RequestDispatcher dispatcher=
                request.getRequestDispatcher
                        (String.format("/hello_world?name=%s&quantity=%s",cart.getName(),cart.getQuantity()));
//                request.getRequestDispatcher(String.format("/secondJsp_hello_world",name));
//                request.getRequestDispatcher(String.format("/jsp_hello_world",name));
        dispatcher.forward(request,response);

    }

    private Cart nullCheck(String name, String quantity, HttpSession session, Cart cart) {
        if (name != null && quantity != null) {
            cart = new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}
