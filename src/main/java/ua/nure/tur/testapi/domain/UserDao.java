package ua.nure.tur.testapi.domain;


import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.entity.User;
import ua.nure.tur.testapi.util.DbConnector;
import ua.nure.tur.testapi.util.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    public User findUserByLogin(String login){
        User user = null;

        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from users";

            PreparedStatement statement = connection.prepareStatement(query);

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
