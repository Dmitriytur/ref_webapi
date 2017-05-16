package ua.nure.tur.testapi.data.sqldao;

import com.fasterxml.jackson.databind.ser.std.SqlDateSerializer;
import ua.nure.tur.testapi.data.interfaces.StateDao;
import ua.nure.tur.testapi.data.util.DbConnector;
import ua.nure.tur.testapi.data.util.Mapper;
import ua.nure.tur.testapi.entity.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

public class SqlStateDao implements StateDao {

    @Override
    public Collection<State> getAllItems() {
        Collection<State> states;
        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from states";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            states = Mapper.toStates(resultSet);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            states = new ArrayList<>();
        }
        return states;
    }

    @Override
    public State getItem(int id) {
        State State = null;

        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from states where id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            State = Mapper.toStates(resultSet).stream().findFirst().orElse(null);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return State;
    }

    @Override
    public void create(State item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "INSERT INTO `states`\n" +
                    "(`user_id`,\n" +
                    "`location_x`,\n" +
                    "`location_y`,\n" +
                    "`temperature`,\n" +
                    "`breathing`,\n" +
                    "`hearth`,\n" +
                    "`time`)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(query);

            DateFormat dateFormat = Mapper.getDateFormat();

            statement.setInt(1, item.getUserId());
            statement.setDouble(2, item.getX());
            statement.setDouble(3, item.getY());
            statement.setDouble(4, item.getTemperature());
            statement.setInt(5, item.getBreathing());
            statement.setInt(6, item.getHearth());
            statement.setString (7,   dateFormat.format(item.getTime()));

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void update(State item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "UPDATE `states`\n" +
                    "SET\n" +
                    "`user_id` = ?,\n" +
                    "`location_x` = ?,\n" +
                    "`location_y` = ?,\n" +
                    "`temperature` = ?,\n" +
                    "`breathing` = ?,\n" +
                    "`hearth` = ?,\n" +
                    "`time` = ?\n" +
                    "WHERE `id` = ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            DateFormat dateFormat = Mapper.getDateFormat();

            statement.setInt(1, item.getUserId());
            statement.setDouble(2, item.getX());
            statement.setDouble(3, item.getY());
            statement.setDouble(4, item.getTemperature());
            statement.setInt(5, item.getBreathing());
            statement.setInt(6, item.getHearth());
            statement.setString (7,   dateFormat.format(item.getTime()));
            statement.setInt(8, item.getId());

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

            String query = "delete form states where id = ?";

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
