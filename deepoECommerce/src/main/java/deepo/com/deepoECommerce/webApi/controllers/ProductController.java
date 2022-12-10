package deepo.com.deepoECommerce.webApi.controllers;

import deepo.com.deepoECommerce.business.abstracts.ProductService;
import deepo.com.deepoECommerce.business.requests.CreateProductRequest;
import deepo.com.deepoECommerce.business.responses.GetAllProductResponse;
import deepo.com.deepoECommerce.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private  ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<GetAllProductResponse> getAll(){
        return productService.getAll();
    }
    @PostMapping ("/add")
    public void add(@RequestBody CreateProductRequest createProductRequest){
        this.productService.add(createProductRequest);
    }
}
