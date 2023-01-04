package deepo.com.deepoECommerce.webApi.controllers;

import deepo.com.deepoECommerce.business.abstracts.ProductService;
import deepo.com.deepoECommerce.entities.concretes.Product;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<Product> getAll(){
        return productService.findAllProduct();
    }
    @PostMapping ("/add")
    public void add(@RequestBody Product product) throws JSONException, IOException, InterruptedException {
        this.productService.addProduct(product);
    }
}
