package ua.nure.tur.testapi.data.sqldao;


import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.data.interfaces.NotificationDao;
import ua.nure.tur.testapi.entity.Notification;
import ua.nure.tur.testapi.data.util.DbConnector;
import ua.nure.tur.testapi.data.util.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class SqlNotificationDao implements NotificationDao {

    @Override
    public Collection<Notification> GetAllItems() {
        Collection<Notification> Notifications;
        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from Notifications";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            Notifications = Mapper.toNotifications(resultSet);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            Notifications = new ArrayList<>();
        }
        return Notifications;
    }

    @Override
    public Notification GetItem(int id) {
        Notification Notification = null;

        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from Notifications where id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            Notification = Mapper.toNotifications(resultSet).stream().findFirst().orElse(null);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return Notification;
    }

    @Override
    public void Create(Notification item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "insert into Notifications " +
                    "(`user_id`,\n" +
                    "`message`,\n" +
                    "`time`,\n" +
                    "`is_read`)\n" +
                    "VALUES (?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, item.getUserId());
            statement.setString(2, item.getMessage());
            statement.setDate(3, item.getTime());
            statement.setBoolean(4, item.isRead());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Update(Notification item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "UPDATE `Notifications`\n" +
                    "SET\n" +
                    "`user_id` = ?,\n" +
                    "`message` = ?,\n" +
                    "`time` = ?,\n" +
                    "`is_read` = ?\n" +
                    "WHERE `id` = ?;\n";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, item.getUserId());
            statement.setString(2, item.getMessage());
            statement.setDate(3, item.getTime());
            statement.setBoolean(4, item.isRead());
            statement.setInt(5, item.getId());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Delete(int id) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "delete form Notifications where id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }



}
