package pl.coderslab.warsztaty3.dao;

import pl.coderslab.warsztaty3.models.Customer;
import pl.coderslab.warsztaty3.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public static List<Customer> loadAll() {
        List<Customer> result = new ArrayList<>();
        final String sql = "SELECT id, first_name, last_name FROM customer;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Customer loadById(int id) {
        Customer result = null;

        final String sql = "SELECT id, first_name, last_name " +
                "FROM customer " +
                "WHERE id=?";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
