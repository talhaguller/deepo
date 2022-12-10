package deepo.com.deepoECommerce.webApi.controllers;

import deepo.com.deepoECommerce.business.abstracts.CustomerService;
import deepo.com.deepoECommerce.business.responses.GetAllCustomerResponse;
import deepo.com.deepoECommerce.entities.concretes.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {


    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getall")
    public List<GetAllCustomerResponse> getAll(){
        return customerService.getAll();
    }

}
