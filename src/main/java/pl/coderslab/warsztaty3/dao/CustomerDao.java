package pl.coderslab.warsztaty3.dao;

import pl.coderslab.warsztaty3.models.Customer;
import pl.coderslab.warsztaty3.models.Employee;
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
        final String sql = "SELECT id, first_name, last_name, birth_date FROM customer;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Customer loadById(int id) {
        Customer result = null;

        final String sql = "SELECT id, first_name, last_name, birth_date " +
                "FROM customer " +
                "WHERE id=?";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void save(Customer customer) {
        if (customer.getId() == 0) {
            insert(customer);
        } else {
            update(customer);
        }
    }

    private static int getGeneratedId(PreparedStatement ps) throws SQLException {
        int result = 0;
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            result = rs.getInt(1);
        }
        rs.close();

        return result;
    }

    private static void insert(Customer customer) {
        final String sql = "INSERT INTO customer " +
                "(first_name, last_name, birth_date) " +
                "VALUES (?, ?, ?);";

        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getBirthDate());
            ps.executeUpdate();
            customer.setId(getGeneratedId(ps));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update(Customer customer) {
        final String sql = "UPDATE customer SET first_name=?, last_name=?, birth_date=? " +
                "WHERE id = ?;";

        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getBirthDate());
            ps.setInt(4, customer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Customer customer) {
        final String sql = "DELETE FROM customer " +
                "WHERE id = ?;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, customer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
