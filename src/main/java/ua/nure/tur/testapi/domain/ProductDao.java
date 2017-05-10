package ua.nure.tur.testapi.domain;

import org.springframework.stereotype.Repository;
import ua.nure.tur.testapi.entity.Product;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class ProductDao {

    private static ArrayList<Product> products;

    static {

        products = new ArrayList<>();
        products.add(new Product(1, "butter", 12, 1  ));
        products.add(new Product(1, "bread", 13, 1  ));
        products.add(new Product(1, "milk", 54, 2  ));
        products.add(new Product(1, "nuts", 32, 2  ));
    }

    public Collection<Product> getAllProducts(){
        return products;
    }


}
