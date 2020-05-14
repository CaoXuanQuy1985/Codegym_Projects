package com.codegym;

import com.codegym.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet{
    private static List<Customer> customers = new ArrayList<Customer>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String image = request.getParameter("image");

        Customer customer = new Customer(name, birthday, address, image);
        Customer customer1 = new Customer("Cao Xuan Quy", "21/01/1985", "Ha Noi", "web/images/Hacker.jpg");
        Customer customer2 = new Customer("anonymous.vn1985", "10/10/1998", "Thai Binh", "web/images/Hacker.jpg");
        Customer customer3 = new Customer("hacker", "01/02/2984", "Hai Phong", "web/images/Hacker.jpg");
        customers.addAll(Arrays.asList(customer, customer1, customer2, customer3));
        request.setAttribute("listCustomer", customers);

        try {
            if (customers.size() == 2) {
                getServletContext().getRequestDispatcher("/index").forward(request, response);
            }
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse resposne) {

    }
}
