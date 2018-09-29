package pl.coderslab.warsztaty3.servlet.customer;

import pl.coderslab.warsztaty3.dao.CustomerDao;
import pl.coderslab.warsztaty3.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerListServlet",urlPatterns = "/customer/list")
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = CustomerDao.loadAll();
        request.setAttribute("customers",customers);
        getServletContext().getRequestDispatcher("/WEB-INF/views/customer/list.jsp").forward(request,response);
    }
}
