package pl.coderslab.warsztaty3.servlet;

import pl.coderslab.warsztaty3.dao.CustomerDao;
import pl.coderslab.warsztaty3.dao.OrderDao;
import pl.coderslab.warsztaty3.dao.StatusDao;
import pl.coderslab.warsztaty3.models.Customer;
import pl.coderslab.warsztaty3.models.Order;
import pl.coderslab.warsztaty3.models.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Status status = StatusDao.loadById(3);
        List<Order> orders = OrderDao.loadByStatus(status);
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
