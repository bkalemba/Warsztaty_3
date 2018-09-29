package pl.coderslab.warsztaty3.servlet.employee;

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
import java.util.List;

@WebServlet(name = "EmployeeListServlet",urlPatterns = "/employee/list")
public class EmployeeListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = EmployeeDao.loadAll();
        request.setAttribute("employees",employees);
        getServletContext().getRequestDispatcher("/WEB-INF/views/employee/list.jsp").forward(request,response);
    }
}
