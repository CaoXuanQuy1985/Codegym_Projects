import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        float operand1 = Float.parseFloat(request.getParameter("operand1"));
        float operand2 = Float.parseFloat(request.getParameter("operand2"));
        String operator = request.getParameter("operator");
        float result = 0.0f;

        Calculator calculator = new Calculator();
        result = calculator.calculate(operand1, operand2, operator);

        request.setAttribute("result", result);

        try {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            ex.printStackTrace();
        }
    }
}
