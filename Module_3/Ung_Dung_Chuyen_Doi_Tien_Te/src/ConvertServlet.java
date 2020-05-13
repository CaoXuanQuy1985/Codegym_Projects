import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ConvertServlet", urlPatterns = "/convert")
public class ConvertServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        float usd = Float.parseFloat(request.getParameter("usd"));
        float ratio = Float.parseFloat(request.getParameter("ratio"));
        float vnd = ratio * usd;
        HttpSession session = request.getSession();
        session.setAttribute("result", vnd);
        try {
            String redirectURL = "/index.jsp";
            getServletContext().getRequestDispatcher(redirectURL).forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
