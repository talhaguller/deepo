package deepo.com.deepoECommerce.business.concretes;

import deepo.com.deepoECommerce.business.abstracts.AuthDataService;
import deepo.com.deepoECommerce.dataAccess.abstracts.CustomerRepository;
import deepo.com.deepoECommerce.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class AuthDataManager implements AuthDataService {

    private final CustomerRepository customerRepository;
    @Autowired
    public AuthDataManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findByUsername(String username) {
        Optional<Customer> result = customerRepository.findByUsername(username);

        Customer customer = new Customer();

        if (result.isPresent()) {
            customer = result.get();
        }


        return customer;
    }

    @Override
    public Customer findByEmail(String email) {
        Optional<Customer> result = customerRepository.findByEmail(email);

        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
       return customerRepository.findAll();
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteByUsernamePassword(String username, String password)  {
        customerRepository.deleteByUsernamePassword(username, password);

    }

    @Override
    public void createUserProfile(Customer customer)  {
        customerRepository.createUserProfile(customer.getUsername(),
                customer.getFirstName(), customer.getLastName(),
                customer.getEmail(), customer.getRePassword(),customer.getPassword());
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}


