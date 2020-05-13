import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

@WebServlet("/translate")
public class TranslateServlet extends HttpServlet {
    static Map<String, String> hashMap = new HashMap<String,String>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        hashMap.put("Home", "Ngôi Nhà");
        hashMap.put("Function", "Chức Năng");
        hashMap.put("Garden", "Khu Vườn");
        hashMap.put("Cat", "Con mèo");

        String eng = request.getParameter("english");
        String vn = hashMap.get(eng);
        if (vn != null) {
            request.setAttribute("vietnamese", vn);
            try {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
