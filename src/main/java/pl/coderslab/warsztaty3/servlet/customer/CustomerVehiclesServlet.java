package pl.coderslab.warsztaty3.servlet.customer;

import pl.coderslab.warsztaty3.dao.CustomerDao;
import pl.coderslab.warsztaty3.dao.OrderDao;
import pl.coderslab.warsztaty3.dao.VehicleDao;
import pl.coderslab.warsztaty3.models.Customer;
import pl.coderslab.warsztaty3.models.Order;
import pl.coderslab.warsztaty3.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerVehiclesServlet",urlPatterns = "/customer/vehicles")
public class CustomerVehiclesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = CustomerDao.loadById(Integer.parseInt(request.getParameter("customerId")));
        List<Vehicle> vehicles = VehicleDao.loadByCustomer(customer);
        request.setAttribute("customer",customer);
        request.setAttribute("vehicles",vehicles);
        getServletContext().getRequestDispatcher("/WEB-INF/views/customer/vehicles.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
