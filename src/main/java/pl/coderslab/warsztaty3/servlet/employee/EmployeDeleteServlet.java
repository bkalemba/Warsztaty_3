package pl.coderslab.warsztaty3.servlet.employee;

import pl.coderslab.warsztaty3.dao.EmployeeDao;
import pl.coderslab.warsztaty3.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeDeleteServlet", urlPatterns = "/employee/delete")
public class EmployeDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirm = request.getParameter("confirm");
        String employeeId = request.getParameter("employeeId");
        Employee employee = EmployeeDao.loadById(Integer.parseInt(employeeId));
        if(confirm == null){
            request.setAttribute("employee",employee);
            getServletContext().getRequestDispatcher("/WEB-INF/views/employee/delete.jsp").forward(request,response);
        } else {
            EmployeeDao.delete(employee);
            response.sendRedirect("/employee/list");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
