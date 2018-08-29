package beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class RegisterBean {
    @Resource(mappedName = "jdbc/kurswork")
    DataSource ds;

    public User register(String login, String password) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement("insert into user (login, password) values (?,?)");
            ps1.setString(1, login);
            ps1.setString(2, password);
            int rowCount = ps1.executeUpdate();
            if (rowCount==0) {
                return new User(0, login, password);
            }
            PreparedStatement ps2 = connection.prepareStatement("select * from user where login = ?");
            ps2.setString(1, login);
            ResultSet resultSet = ps2.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            } else {
                return new User();
            }
        } catch (SQLException e) {
            return new User(0, login, password);
        }
    }

    public User find(String login, String password) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("select * from user where login = ? AND password = ?");
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt(1), login, password);
            } else {
                return new User(0, login, password);
            }
        } catch (SQLException e) {
            return new User(0, login, password);
        }
    }
}
