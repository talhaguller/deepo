package deepo.com.deepoECommerce.business.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Product;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service

public interface ProductService {


    List<Product> findAllProduct();

    Optional<Product> findById(int id);

    Product updateProduct(Product product);

    void addProduct(Product product)throws IOException, InterruptedException, JSONException;

}
