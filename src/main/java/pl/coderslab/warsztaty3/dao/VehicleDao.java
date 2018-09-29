package pl.coderslab.warsztaty3.dao;

import pl.coderslab.warsztaty3.models.Customer;
import pl.coderslab.warsztaty3.models.Vehicle;
import pl.coderslab.warsztaty3.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    public static List<Vehicle> loadAll() {
        List<Vehicle> result = new ArrayList<>();
        final String sql = "SELECT id, brand, model, year, license_plate, next_review, customer_id FROM vehicle;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = CustomerDao.loadById(rs.getInt(7));
                result.add(new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),customer));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Vehicle loadById(int id) {
        Vehicle result = null;

        final String sql = "SELECT id, brand, model, year, license_plate, next_review, customer_id FROM vehicle " +
                "WHERE id=?";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer customer = CustomerDao.loadById(rs.getInt(7));
                result = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),customer);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Vehicle> loadByCustomer(Customer cust) {
        List<Vehicle> result = new ArrayList<>();
        final String sql = "SELECT id, brand, model, year, license_plate, next_review, customer_id FROM vehicle "+
                "WHERE customer_id=?;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,cust.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = CustomerDao.loadById(rs.getInt(7));
                result.add(new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),customer));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
