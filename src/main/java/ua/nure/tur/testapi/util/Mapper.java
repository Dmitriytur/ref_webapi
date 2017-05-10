package ua.nure.tur.testapi.util;

import ua.nure.tur.testapi.entity.Shop;
import ua.nure.tur.testapi.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class Mapper {

    public static Collection<Shop> toShops(ResultSet resultSet) throws SQLException {
        ArrayList<Shop> shops = new ArrayList<>();

        while (resultSet.next())
        {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String price = resultSet.getString("address");

            shops.add(new Shop(id, name, price));
        }
        return shops;

    }

    public static Collection<User> toUsers(ResultSet resultSet) throws SQLException {

        ArrayList<User> users = new ArrayList<>();

        while (resultSet.next())
        {
            int id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");

            users.add(new User(id, login, password));
        }
        return users;
    }
}
