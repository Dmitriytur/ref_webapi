package ua.nure.tur.testapi.util;

import ua.nure.tur.testapi.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class Mapper {

    public static Collection<User> toUsers(ResultSet rs) throws SQLException {

        ArrayList<User> items = new ArrayList<>();

        while (rs.next())
        {
            User item = new User();

            item.setId(rs.getInt("id"));
            item.setUsername(rs.getString("username"));
            item.setPassword(rs.getString("password"));
            item.setEmail(rs.getString("email"));
            item.setFirstname(rs.getString("firstname"));
            item.setSecondname(rs.getString("secondname"));

            items.add(item);
        }
        return items;
    }


    public static Collection<State> toStates(ResultSet rs) throws SQLException {

        ArrayList<State> items = new ArrayList<>();

        while (rs.next())
        {
            State item = new State();

            item.setId(rs.getInt("id"));
            item.setUserId(rs.getInt("user_id"));
            item.setX(rs.getDouble("location_x"));
            item.setY(rs.getDouble("location_y"));
            item.setTemperature(rs.getDouble("temperature"));
            item.setBreathing(rs.getInt("breathing"));
            item.setHearth(rs.getInt("hearth"));
            item.setTime(rs.getDate("time"));

            items.add(item);
        }
        return items;
    }

    public static Collection<Photo> toPhotos(ResultSet rs) throws SQLException {

        ArrayList<Photo> items = new ArrayList<>();

        while (rs.next())
        {
            Photo item = new Photo();

            item.setId(rs.getInt("id"));
            item.setUserId(rs.getInt("user_id"));
            item.setCameraId(rs.getInt("camera_id"));
            item.setPhoto(rs.getString("photo"));

            items.add(item);
        }
        return items;
    }


    public static Collection<Permission> toPermissions(ResultSet rs) throws SQLException {

        ArrayList<Permission> items = new ArrayList<>();

        while (rs.next())
        {
            Permission item = new Permission();

            item.setId(rs.getInt("id"));
            item.setUserFrom(rs.getInt("user_from"));
            item.setUserTo(rs.getInt("user_to"));
            item.setLocation(rs.getBoolean("location"));
            item.setBiometry(rs.getBoolean("biometry"));
            item.setPhoto(rs.getBoolean("photo"));

            items.add(item);
        }
        return items;
    }


    public static Collection<Notification> toNotifications(ResultSet rs) throws SQLException {

        ArrayList<Notification> items = new ArrayList<>();

        while (rs.next())
        {
            Notification item = new Notification();

            item.setId(rs.getInt("id"));
            item.setUserId(rs.getInt("user_id"));
            item.setMessage(rs.getString("message"));
            item.setTime(rs.getDate("time"));
            item.setRead(rs.getBoolean("is_read"));

            items.add(item);
        }
        return items;
    }


    public static Collection<Camera> toCameras(ResultSet rs) throws SQLException {

        ArrayList<Camera> items = new ArrayList<>();

        while (rs.next())
        {
            Camera item = new Camera();

            item.setId(rs.getInt("id"));
            item.setX(rs.getDouble("location_x"));
            item.setY(rs.getDouble("location_y"));

            items.add(item);
        }
        return items;
    }

}





























