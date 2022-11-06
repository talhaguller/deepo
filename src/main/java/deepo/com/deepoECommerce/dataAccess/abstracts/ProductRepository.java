package deepo.com.deepoECommerce.dataAccess.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    List<Product>getAll();
}
