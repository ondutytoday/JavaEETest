import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LibraryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testDB",
                    "postgres", "EVas0003!");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM users");
            while (rs.next()) {
                pw.println(rs.getString("name"));
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
