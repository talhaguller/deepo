package deepo.com.deepoECommerce.business.concretes;

import deepo.com.deepoECommerce.business.abstracts.ProductService;
import deepo.com.deepoECommerce.dataAccess.abstracts.ProductRepository;
import deepo.com.deepoECommerce.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductManager(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product>getAll() {

        return productRepository.getAll();

    }
}
