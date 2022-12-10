package deepo.com.deepoECommerce.dataAccess.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
