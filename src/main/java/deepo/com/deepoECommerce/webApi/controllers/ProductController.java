package deepo.com.deepoECommerce.webApi.controllers;

import deepo.com.deepoECommerce.business.abstracts.ProductService;
import deepo.com.deepoECommerce.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController //annotation(bilgilendirme)
@RequestMapping("/api/brands ")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }
    @GetMapping("/getAll")
    public List<Product>getAll(){
        return productService.getAll();
    }
}
