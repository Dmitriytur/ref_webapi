package ua.nure.tur.testapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.domain.ShopDao;
import ua.nure.tur.testapi.entity.Shop;

import java.util.Collection;

@Service
public class ShopService {

    @Autowired
    private ShopDao shopDao;

    public Collection<Shop> getAllShops(){
        return shopDao.getAllShops();
    }

    public void addShop(Shop shop){
        shopDao.addShop(shop);
    }
}
