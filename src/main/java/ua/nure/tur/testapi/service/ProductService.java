package ua.nure.tur.testapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.domain.ProductDao;
import ua.nure.tur.testapi.entity.Product;

import java.util.Collection;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Collection<Product> getAllProducts(){
        return productDao.getAllProducts();
    }
}
