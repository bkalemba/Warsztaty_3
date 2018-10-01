package pl.coderslab.warsztaty3.dao;

import pl.coderslab.warsztaty3.models.*;
import pl.coderslab.warsztaty3.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {


    //id INT AUTO_INCREMENT PRIMARY KEY,
//        vehicle_id INT,
//        employee_id INT,
//        status_id INT,
//        created DATETIME,
//        expected_start DATETIME,
//        actual_start DATETIME,
//        customer_description VARCHAR(255),
//        employee_description VARCHAR(255),
//        final_cost DOUBLE(9,2),
//        parts_cost DOUBLE(9,2),
//        work_hours DOUBLE(9,2),
    public static List<Order> loadAll() {
        List<Order> result = new ArrayList<>();
        final String sql = "SELECT id, vehicle_id, employee_id, status_id, created, expected_start, actual_start, customer_description, employee_description, final_cost, parts_cost, work_hours FROM orders;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = VehicleDao.loadById(rs.getInt(2));
                Employee employee = EmployeeDao.loadById(rs.getInt(3));
                Status status = StatusDao.loadById(rs.getInt(4));
                result.add(new Order(rs.getInt(1), vehicle, employee, status, rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getDouble(12)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Order loadById(int id) {
        Order result = null;

        final String sql = "SELECT id, vehicle_id, employee_id, status_id, created, expected_start, actual_start, customer_description, employee_description, final_cost, parts_cost, work_hours FROM orders " +
                "WHERE id=?";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = VehicleDao.loadById(rs.getInt(2));
                Employee employee = EmployeeDao.loadById(rs.getInt(3));
                Status status = StatusDao.loadById(rs.getInt(4));
                result = new Order(rs.getInt(1), vehicle, employee, status, rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getDouble(12));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Order> loadByStatus(Status status) {
        List<Order> result = new ArrayList<>();
        final String sql = "SELECT id, vehicle_id, employee_id, status_id, created, expected_start, actual_start, customer_description, employee_description, final_cost, parts_cost, work_hours FROM orders " +
                "WHERE status_id=?;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, status.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = VehicleDao.loadById(rs.getInt(2));
                Employee employee = EmployeeDao.loadById(rs.getInt(3));
                result.add(new Order(rs.getInt(1), vehicle, employee, status, rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getDouble(12)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Order> loadByEmployee(Employee employee) {
        List<Order> result = new ArrayList<>();
        final String sql = "SELECT id, vehicle_id, employee_id, status_id, created, expected_start, actual_start, customer_description, employee_description, final_cost, parts_cost, work_hours FROM orders " +
                "WHERE employee_id=?;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, employee.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = VehicleDao.loadById(rs.getInt(2));
                Status status = StatusDao.loadById(rs.getInt(4));
                result.add(new Order(rs.getInt(1), vehicle, employee, status, rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getDouble(12)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Order> loadByVehicle(Vehicle vehicle) {
        List<Order> result = new ArrayList<>();
        final String sql = "SELECT id, vehicle_id, employee_id, status_id, created, expected_start, actual_start, customer_description, employee_description, final_cost, parts_cost, work_hours FROM orders " +
                "WHERE vehicle_id=?;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, vehicle.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = EmployeeDao.loadById(rs.getInt(3));
                Status status = StatusDao.loadById(rs.getInt(4));
                result.add(new Order(rs.getInt(1), vehicle, employee, status, rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getDouble(12)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Order> loadByCustomer(Customer customer){
        List<Order> result = new ArrayList<>();
        List<Vehicle> vehicles = VehicleDao.loadByCustomer(customer);
        for (Vehicle vehicle : vehicles) {
            List<Order> orders = loadByVehicle(vehicle);
            result.addAll(orders);
        }
        return result;
    }

}
