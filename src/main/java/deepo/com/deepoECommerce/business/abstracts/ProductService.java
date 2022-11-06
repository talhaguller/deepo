package deepo.com.deepoECommerce.business.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
