package deepo.com.deepoECommerce.business.concretes;

import deepo.com.deepoECommerce.business.abstracts.ProductService;
import deepo.com.deepoECommerce.business.requests.CreateProductRequest;
import deepo.com.deepoECommerce.business.responses.GetAllProductResponse;
import deepo.com.deepoECommerce.dataAccess.abstracts.ProductRepository;
import deepo.com.deepoECommerce.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //İş Kuralları
    @Override
    public List<GetAllProductResponse> getAll() {

        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> productResponse = new ArrayList<GetAllProductResponse>();

        for (Product product: products) {
            GetAllProductResponse responseItem = new GetAllProductResponse();
            responseItem.setProductId(product.getProductId());
            responseItem.setProductName(product.getProductName());
            responseItem.setSupplierId(product.getSupplierId());
            responseItem.setCategoryId(product.getCategoryId());
            responseItem.setUnitPrice(product.getUnitPrice());
            responseItem.setUnitPrice(product.getUnitPrice());
            responseItem.setUnitsInStock(product.getUnitsInStock());
            responseItem.setDiscontinued(product.getDiscontinued());

            productResponse.add(responseItem);
        }

        return productResponse;
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {
        Product product = new Product();
        product.setProductName(createProductRequest.getProductName());
        product.setSupplierId(createProductRequest.getSupplierId());
        product.setCategoryId(createProductRequest.getCategoryId());
        product.setUnitPrice(createProductRequest.getUnitPrice());
        product.setUnitsInStock(createProductRequest.getUnitsInStock());
        product.setDiscontinued(createProductRequest.getDiscontinued());

        this.productRepository.save(product);
    }


}
