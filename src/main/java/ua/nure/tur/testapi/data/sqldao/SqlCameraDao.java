package ua.nure.tur.testapi.data.sqldao;


import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.data.interfaces.CameraDao;
import ua.nure.tur.testapi.entity.Camera;
import ua.nure.tur.testapi.data.util.DbConnector;
import ua.nure.tur.testapi.data.util.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class SqlCameraDao implements CameraDao {

    @Override
    public Collection<Camera> GetAllItems() {
        Collection<Camera> Cameras;
        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from Cameras";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            Cameras = Mapper.toCameras(resultSet);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            Cameras = new ArrayList<>();
        }
        return Cameras;
    }

    @Override
    public Camera GetItem(int id) {
        Camera Camera = null;

        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from Cameras where id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            Camera = Mapper.toCameras(resultSet).stream().findFirst().orElse(null);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return Camera;
    }

    @Override
    public void Create(Camera item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "insert into Cameras " +
                    "(`location_x`,\n" +
                    "`location_y`)\n" +
                    "VALUES (?, ?);";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, item.getX());
            statement.setDouble(2, item.getY());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Update(Camera item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "UPDATE `Cameras`\n" +
                    "SET\n" +
                    "`location_x` = ?,\n" +
                    "`location_y` = ?\n" +
                    "WHERE `id` = ?;\n";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, item.getX());
            statement.setDouble(2, item.getY());
            statement.setInt(3, item.getId());

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

            String query = "delete form Cameras where id = ?";

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
