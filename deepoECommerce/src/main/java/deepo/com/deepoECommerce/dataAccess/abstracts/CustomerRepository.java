package deepo.com.deepoECommerce.dataAccess.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Customer;
import deepo.com.deepoECommerce.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    Customer findByUsername(String username);

    Customer findByEmail(String email);
}
