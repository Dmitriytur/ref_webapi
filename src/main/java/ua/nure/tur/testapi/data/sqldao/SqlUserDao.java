package ua.nure.tur.testapi.data.sqldao;


import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.data.interfaces.UserDao;
import ua.nure.tur.testapi.entity.User;
import ua.nure.tur.testapi.data.util.DbConnector;
import ua.nure.tur.testapi.data.util.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class SqlUserDao implements UserDao {

    @Override
    public Collection<User> GetAllItems() {
        Collection<User> users;
        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from users";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            users = Mapper.toUsers(resultSet);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            users = new ArrayList<>();
        }
        return users;
    }

    @Override
    public User GetItem(int id) {
        User user = null;

        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from users where id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            user = Mapper.toUsers(resultSet).stream().findFirst().orElse(null);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public void Create(User item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "insert into users " +
                    "(`username`, `password`, `email`, `firstname`, `secondname`) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, item.getUsername());
            statement.setString(2, item.getPassword());
            statement.setString(3, item.getEmail());
            statement.setString(4, item.getFirstname());
            statement.setString(5, item.getSecondname());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Update(User item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "UPDATE `users`\n" +
                    "SET\n" +
                    "`password` = ?,\n" +
                    "`email` = ?>,\n" +
                    "`firstname` = ?,\n" +
                    "`secondname` = ?\n" +
                    "WHERE `id` = ?;\n";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, item.getPassword());
            statement.setString(2, item.getEmail());
            statement.setString(3, item.getFirstname());
            statement.setString(4, item.getSecondname());
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

            String query = "delete form users where id = ?";

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
    public User findUserByUserName(String username){
        User user = null;

        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from users where username = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            user = Mapper.toUsers(resultSet).stream().findFirst().orElse(null);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return user;
    }


}
