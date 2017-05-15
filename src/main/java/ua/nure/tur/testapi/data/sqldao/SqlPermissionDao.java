package ua.nure.tur.testapi.data.sqldao;


import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.data.interfaces.PermissionDao;
import ua.nure.tur.testapi.entity.Permission;
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
    public Collection<Permission> GetAllItems() {
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
    public Permission GetItem(int id) {
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
    public void Create(Permission item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "insert into Permissions " +
                    "(user_from`,\n" +
                    "`user_to`,\n" +
                    "`location`,\n" +
                    "`biometry`,\n" +
                    "`photo`)\n" +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, item.getUserFrom());
            statement.setInt(2, item.getUserTo());
            statement.setBoolean(3, item.isLocation());
            statement.setBoolean(4, item.isBiometry());
            statement.setBoolean(5, item.isPhoto());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Update(Permission item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "UPDATE `Permissions`\n" +
                    "SET\n" +
                    "`user_from` = ?,\n" +
                    "`user_to` = ?,\n" +
                    "`location` = ?,\n" +
                    "`biometry` = ?,\n" +
                    "`photo` = ?\n" +
                    "WHERE `id` = ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, item.getUserFrom());
            statement.setInt(2, item.getUserTo());
            statement.setBoolean(3, item.isLocation());
            statement.setBoolean(4, item.isBiometry());
            statement.setBoolean(5, item.isPhoto());
            statement.setInt(6, item.getId());

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



}
