package ua.nure.tur.testapi.domain;


import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.entity.User;
import ua.nure.tur.testapi.util.DbConnector;
import ua.nure.tur.testapi.util.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class UserRepository implements UserDao{

    @Override
    public Collection<User> GetAllItems() {
        Collection<User> shops;
        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from users";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            shops = Mapper.toUsers(resultSet);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            shops = new ArrayList<>();
        }
        return shops;
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
                    "(`username`, `password`, `email`, `role`, `firstname`, `secondname`) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, item.getUsername());
            statement.setString(2, item.getPassword());
            statement.setString(3, item.getEmail());
            statement.setString(4, item.getRole());
            statement.setString(5, item.getFirstname());
            statement.setString(6, item.getSecondname());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Update(User item) {

    }

    @Override
    public void Delete(int id) {

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
