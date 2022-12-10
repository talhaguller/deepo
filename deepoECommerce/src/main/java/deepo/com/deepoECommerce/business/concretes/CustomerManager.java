package deepo.com.deepoECommerce.business.concretes;

import deepo.com.deepoECommerce.business.abstracts.CustomerService;
import deepo.com.deepoECommerce.business.responses.GetAllCustomerResponse;
import deepo.com.deepoECommerce.business.responses.GetAllProductResponse;
import deepo.com.deepoECommerce.dataAccess.abstracts.CustomerRepository;
import deepo.com.deepoECommerce.dataAccess.abstracts.RoleRepesitory;
import deepo.com.deepoECommerce.entities.concretes.Customer;
import deepo.com.deepoECommerce.entities.concretes.Product;
import deepo.com.deepoECommerce.entities.concretes.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    CustomerRepository customerRepository;
    RoleRepesitory roleRepesitory;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponse> customerResponses = new ArrayList<GetAllCustomerResponse>();

        for (Customer customer: customers) {
            GetAllCustomerResponse responseItem = new GetAllCustomerResponse();
            responseItem.setCustomer_id(customer.getCustomer_id());
            responseItem.setUsername(customer.getUsername());
            responseItem.setPassword(customer.getPassword());
            responseItem.setRePassword(customer.getRePassword());
            responseItem.setEnabled(customer.isEnabled());
            responseItem.setRole(customer.getRole());
            responseItem.setEmail(customer.getEmail());
            customerResponses.add(responseItem);
        }

        return customerResponses;
    }


    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public void saveCustomer(Customer customer) {
        customer.setRole(Arrays.asList(roleRepesitory.findByRole("CUSTOMER")).toString());
        customer.setEnabled(true);
        customerRepository.save(customer);
    }
}
