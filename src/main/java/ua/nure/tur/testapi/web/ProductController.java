package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.tur.testapi.entity.Product;
import ua.nure.tur.testapi.service.ProductService;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
