package pl.coderslab.warsztaty3.dao;

import pl.coderslab.warsztaty3.models.Customer;
import pl.coderslab.warsztaty3.models.Status;
import pl.coderslab.warsztaty3.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {

    public static List<Status> loadAll() {
        List<Status> result = new ArrayList<>();
        final String sql = "SELECT id, description FROM status;";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Status(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Status loadById(int id) {
        Status result = null;

        final String sql = "SELECT id, description " +
                "FROM status " +
                "WHERE id=?";
        try (Connection connection = DbUtil.getConn();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = new Status(rs.getInt(1), rs.getString(2));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
