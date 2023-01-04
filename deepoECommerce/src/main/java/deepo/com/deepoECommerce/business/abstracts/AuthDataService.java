package deepo.com.deepoECommerce.business.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AuthDataService {

     Customer findByUsername(String username);

    Customer findByEmail(String email);

    List<Customer> findAll();

    Customer update(Customer customer);

    void deleteByUsernamePassword(String username, String password);

    void createUserProfile(Customer customer);


    void delete(int id);
}
