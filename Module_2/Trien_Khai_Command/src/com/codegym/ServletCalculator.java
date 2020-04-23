package com.codegym;

import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

@WebServlet(name = "ServletCalculator", urlPatterns = "/cal")
public class ServletCalculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String op = request.getParameter("operator");
        int firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
        int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));
        Calculator calculator = new Calculator();
        int result = 0;

        if (op.equals("+")) {
            result = calculator.add(firstNumber, secondNumber);
        } else {
            result = calculator.sub(firstNumber, secondNumber);
        }

        request.setAttribute("result", result);
        request.setAttribute("firstNumber", firstNumber);
        request.setAttribute("secondNumber", secondNumber);
        RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
        dis.forward(request, response);
    }
}
