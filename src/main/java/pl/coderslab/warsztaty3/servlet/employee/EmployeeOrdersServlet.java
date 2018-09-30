package pl.coderslab.warsztaty3.servlet.employee;

import pl.coderslab.warsztaty3.dao.EmployeeDao;
import pl.coderslab.warsztaty3.dao.OrderDao;
import pl.coderslab.warsztaty3.models.Employee;
import pl.coderslab.warsztaty3.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeOrdersServlet",urlPatterns = "/employee/orders")
public class EmployeeOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = EmployeeDao.loadById(Integer.parseInt(request.getParameter("employeeId")));
        List<Order> orders = OrderDao.loadByEmployee(employee);
        request.setAttribute("employee",employee);
        request.setAttribute("orders",orders);
        getServletContext().getRequestDispatcher("/WEB-INF/views/employee/orders.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
