package ua.nure.tur.testapi.data.sqldao;


import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.data.interfaces.PermissionDao;
import ua.nure.tur.testapi.entities.Permission;
import ua.nure.tur.testapi.data.util.DbConnector;
import ua.nure.tur.testapi.data.util.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class SqlPermissionDao implements PermissionDao {

    @Override
    public Collection<Permission> getAllItems() {
        Collection<Permission> Permissions;
        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from Permissions";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            Permissions = Mapper.toPermissions(resultSet);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            Permissions = new ArrayList<>();
        }
        return Permissions;
    }

    @Override
    public Permission getItem(int id) {
        Permission Permission = null;

        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from Permissions where id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            Permission = Mapper.toPermissions(resultSet).stream().findFirst().orElse(null);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return Permission;
    }

    @Override
    public void create(Permission item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "insert into Permissions " +
                    "(`user_from`,\n" +
                    "`user_to`,\n" +
                    "`location`,\n" +
                    "`biometry`,\n" +
                    "VALUES (?, ?, ?, ?);";


            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, item.getUserFrom());
            statement.setInt(2, item.getUserTo());
            statement.setBoolean(3, item.isLocation());
            statement.setBoolean(4, item.isBiometry());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void update(Permission item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "UPDATE `Permissions`\n" +
                    "SET\n" +
                    "`user_from` = ?,\n" +
                    "`user_to` = ?,\n" +
                    "`location` = ?,\n" +
                    "`biometry` = ?,\n" +
                    "WHERE `id` = ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, item.getUserFrom());
            statement.setInt(2, item.getUserTo());
            statement.setBoolean(3, item.isLocation());
            statement.setBoolean(4, item.isBiometry());
            statement.setInt(5, item.getId());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "delete form Permissions where id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }


    @Override
    public Permission getByFromAndToId(int idFrom, int idTo) {
        Permission permission = null;

        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from Permissions where user_from = ? and user_to = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idFrom);
            statement.setInt(2, idTo);

            ResultSet resultSet = statement.executeQuery();

            permission = Mapper.toPermissions(resultSet).stream().findFirst().orElse(null);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return permission;
    }
}
