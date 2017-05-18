package ua.nure.tur.testapi.data.util;

import ua.nure.tur.testapi.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Mapper {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static DateFormat getDateFormat(){
        return dateFormat;
    }

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
            item.setRole(rs.getString("role"));
            item.setDeviceKey(rs.getString("device_key"));

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

            String time = rs.getString("time");
            Date date = null;
            try {
                date = dateFormat.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            item.setTime(date);


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

            String time = rs.getString("time");

            Date date = null;
            try {
                date = dateFormat.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            item.setTime(date);

            item.setRead(rs.getBoolean("is_read"));

            items.add(item);
        }
        return items;
    }


}





























