package ua.nure.tur.testapi.domain;

import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.entity.Shop;
import ua.nure.tur.testapi.util.DbConnector;
import ua.nure.tur.testapi.util.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class ShopDao {



    public Collection<Shop> getAllShops(){

        Collection<Shop> shops;
        try {
            Connection connection = DbConnector.getConnection();

            String query = "select * from shops";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            shops = Mapper.toShops(resultSet);

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            shops = new ArrayList<>();
        }
        return shops;
    }

    public void addShop(Shop shop){
        try {
            Connection connection = DbConnector.getConnection();

            String query = "insert into shops (name, address) values (?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, shop.getName());
            statement.setString(2, shop.getAddress());

            statement.executeUpdate();

            connection.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
}
