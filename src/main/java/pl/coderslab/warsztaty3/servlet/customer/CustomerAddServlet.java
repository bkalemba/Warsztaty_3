package pl.coderslab.warsztaty3.servlet.customer;

import pl.coderslab.warsztaty3.dao.CustomerDao;
import pl.coderslab.warsztaty3.dao.EmployeeDao;
import pl.coderslab.warsztaty3.models.Customer;
import pl.coderslab.warsztaty3.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerAddServlet", urlPatterns = "/customer/add")
public class CustomerAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setBirthDate(request.getParameter("birthDate"));
        CustomerDao.save(customer);
        response.sendRedirect("/customer/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/customer/add.jsp").forward(request,response);
    }
}
