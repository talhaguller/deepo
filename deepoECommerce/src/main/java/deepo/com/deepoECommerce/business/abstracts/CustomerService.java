package deepo.com.deepoECommerce.business.abstracts;

import deepo.com.deepoECommerce.business.responses.GetAllCustomerResponse;
import deepo.com.deepoECommerce.business.responses.GetAllProductResponse;
import deepo.com.deepoECommerce.dataAccess.abstracts.CustomerRepository;

import deepo.com.deepoECommerce.entities.concretes.Customer;
import deepo.com.deepoECommerce.entities.concretes.Role;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public interface CustomerService {
    List<GetAllCustomerResponse> getAll();

    Customer findByUsername(String username);

    Customer findByEmail(String email);




}
