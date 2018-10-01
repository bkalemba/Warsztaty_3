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

@WebServlet(name = "CustomerEditServlet",urlPatterns = "/customer/edit")
public class CustomerEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirm = request.getParameter("confirm");
        String customerId = request.getParameter("customerId");
        Customer customer = CustomerDao.loadById(Integer.parseInt(customerId));
        if(confirm == null) {

            request.setAttribute("customer",customer);
            getServletContext().getRequestDispatcher("/WEB-INF/views/customer/edit.jsp").forward(request, response);
        } else {
            customer.setFirstName(request.getParameter("firstName"));
            customer.setLastName(request.getParameter("lastName"));
            customer.setBirthDate(request.getParameter("birthDate"));
            CustomerDao.save(customer);
            response.sendRedirect("/customer/list");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
