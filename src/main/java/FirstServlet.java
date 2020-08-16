import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //сессия
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));


        if (cart == null) {
            cart = new Cart();
        }
            cart.setName(name);
            cart.setQuantity(quantity);


        session.setAttribute("cart", cart);
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 1;
            session.setAttribute("count", count);
        } else
            session.setAttribute("count", count + 1);


        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1> Hi Lena! </h1>");
        pw.println("<h1> Count is " + count + " </h1>");
        pw.println("</html>");

        //redirect
        response.sendRedirect("firstJsp.jsp");

        //forward (chain of responsibility)
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("firstJsp.jsp");
        requestDispatcher.forward(request, response);
    }
}
