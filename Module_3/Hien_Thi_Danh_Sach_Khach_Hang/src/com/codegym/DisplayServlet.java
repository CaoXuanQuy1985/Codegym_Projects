package com.codegym;

import com.codegym.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns="/display")
public class DisplayServlet extends HttpServlet{
    private static List<Customer> customers = new ArrayList<Customer>();
    private static String urlImage = "images/Hacker.jpg";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String image = request.getParameter("image");

        Customer customer = new Customer(name, birthday, address, image);
        Customer customer1 = new Customer("Cao Xuan Quy", "21/01/1985", "Ha Noi", urlImage);
        Customer customer2 = new Customer("anonymous.vn1985", "10/10/1998", "Thai Binh", urlImage);
        Customer customer3 = new Customer("hacker", "01/02/2984", "Hai Phong", urlImage);
        customers.addAll(Arrays.asList(customer, customer1, customer2, customer3));
        request.setAttribute("listCustomer", customers);

        try {
            getServletContext().getRequestDispatcher("/display.jsp").forward(request, response);
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
