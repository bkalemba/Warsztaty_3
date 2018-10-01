package pl.coderslab.warsztaty3.servlet.customer;

import pl.coderslab.warsztaty3.dao.CustomerDao;
import pl.coderslab.warsztaty3.dao.EmployeeDao;
import pl.coderslab.warsztaty3.dao.OrderDao;
import pl.coderslab.warsztaty3.models.Customer;
import pl.coderslab.warsztaty3.models.Employee;
import pl.coderslab.warsztaty3.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerOrdersServlet",urlPatterns = "/customer/orders")
public class CustomerOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = CustomerDao.loadById(Integer.parseInt(request.getParameter("customerId")));
        List<Order> orders = OrderDao.loadByCustomer(customer);
        request.setAttribute("customer",customer);
        request.setAttribute("orders",orders);
        getServletContext().getRequestDispatcher("/WEB-INF/views/customer/orders.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
