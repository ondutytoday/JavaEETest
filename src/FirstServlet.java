import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1> Hi Lena! </h1>");
        pw.println("</html>");

        //redirect
        response.sendRedirect("firstJsp.jsp");

        //forward (chain of resposability)
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("firstJsp.jsp");
        requestDispatcher.forward(request, response);
    }
}
