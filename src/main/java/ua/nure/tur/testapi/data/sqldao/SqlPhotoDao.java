package ua.nure.tur.testapi.data.sqldao;


import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.data.interfaces.PhotoDao;
import ua.nure.tur.testapi.entity.Photo;
import ua.nure.tur.testapi.data.util.DbConnector;
import ua.nure.tur.testapi.data.util.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class SqlPhotoDao implements PhotoDao {

    @Override
    public Collection<Photo> GetAllItems() {
        Collection<Photo> Photos;
        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from Photos";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            Photos = Mapper.toPhotos(resultSet);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            Photos = new ArrayList<>();
        }
        return Photos;
    }

    @Override
    public Photo GetItem(int id) {
        Photo Photo = null;

        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from Photos where id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            Photo = Mapper.toPhotos(resultSet).stream().findFirst().orElse(null);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return Photo;
    }

    @Override
    public void Create(Photo item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "insert into Photos " +
                    "(`user_id`,\n" +
                    "`camera_id`,\n" +
                    "`photo`)\n" +
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, item.getUserId());
            statement.setInt(2, item.getCameraId());
            statement.setString(3, item.getPhoto());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Update(Photo item) {
        try {
            Connection connection = DbConnector.getConnection();

            String query = "UPDATE `Photos`\n" +
                    "SET\n" +
                    "`user_id` = ?,\n" +
                    "`camera_id` = ?,\n" +
                    "`photo` = ?\n" +
                    "WHERE `id` = ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, item.getUserId());
            statement.setInt(2, item.getCameraId());
            statement.setString(3, item.getPhoto());
            statement.setInt(4, item.getId());

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

            String query = "delete form Photos where id = ?";

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
