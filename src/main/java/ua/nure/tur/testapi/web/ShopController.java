package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.tur.testapi.entity.Shop;
import ua.nure.tur.testapi.service.ShopService;

import java.util.Collection;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<Shop> getAllShops(){
        return shopService.getAllShops();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addShop(@RequestBody Shop shop){
        shopService.addShop(shop);

        return "Shop added";
    }
}
