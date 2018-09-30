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

public class EmployeeDao {

    public static List<Employee> loadAll() {
        List<Employee> result = new ArrayList<>();
        final String sql = "SELECT id, first_name, last_name, address, phone, note, hour_cost FROM employee;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Employee loadById(int id) {
        Employee result = null;

        final String sql = "SELECT id, first_name, last_name, address, phone, note, hour_cost FROM employee " +
                "WHERE id=?";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void save(Employee employee) {
        if (employee.getId() == 0) {
            insert(employee);
        } else {
            update(employee);
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

    private static void insert(Employee employee) {
        final String sql = "INSERT INTO employee " +
                "(first_name, last_name, address, phone, note, hour_cost) " +
                "VALUES (?, ?, ?, ?, ?, ?);";

        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getPhone());
            ps.setString(5, employee.getNote());
            ps.setDouble(6, employee.getHourCost());
            ps.executeUpdate();
            employee.setId(getGeneratedId(ps));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update(Employee employee) {
        final String sql = "UPDATE employee SET first_name=?, last_name=?, address=?, phone=?, note=?, hour_cost=? " +
                "WHERE id = ?;";

        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getPhone());
            ps.setString(5, employee.getNote());
            ps.setDouble(6, employee.getHourCost());
            ps.setInt(7, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Employee employee) {
        final String sql = "DELETE FROM employee " +
                "WHERE id = ?;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
