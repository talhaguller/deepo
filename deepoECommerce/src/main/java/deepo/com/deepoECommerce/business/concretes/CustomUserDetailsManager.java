
package deepo.com.deepoECommerce.business.concretes;

import deepo.com.deepoECommerce.business.abstracts.AuthDataService;
import deepo.com.deepoECommerce.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class CustomUserDetailsManager   {


    private final AuthDataService authDataService;

    public Customer loadUserByUsername(String username){
        Customer customer = authDataService.findByUsername(username);
      System.out.println("Username = " +customer.getUsername() + ", Password = " + customer.getPassword());
        return new Customer( customer.getUsername(), customer.getPassword(), Arrays.asList());
    }

}
