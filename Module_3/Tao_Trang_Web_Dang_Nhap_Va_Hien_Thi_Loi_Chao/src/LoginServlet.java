import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = null;

        if (username.equals("admin") && password.equals("admin")) {
            try {
                out = response.getWriter();
                out.println("<html>");
                out.println("<h1>");
                out.println("Xin Chao anh " + username + " dep trai !!!");
                out.println("</h1>");
                out.println("</html>");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
