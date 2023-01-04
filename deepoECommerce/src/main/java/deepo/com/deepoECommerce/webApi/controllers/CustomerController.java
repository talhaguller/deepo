package deepo.com.deepoECommerce.webApi.controllers;

import deepo.com.deepoECommerce.business.abstracts.AuthDataService;
import deepo.com.deepoECommerce.business.concretes.CustomUserDetailsManager;
import deepo.com.deepoECommerce.business.requests.AccountCreationRequest;
import deepo.com.deepoECommerce.business.responses.AccountCreationResponse;
import deepo.com.deepoECommerce.dataAccess.abstracts.CustomerRepository;
import deepo.com.deepoECommerce.entities.concretes.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/customer")

public class CustomerController {


    private final CustomUserDetailsManager customUserDetailsManager;
    private final AuthDataService authDataService;
    private final CustomerRepository customerRepository;


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Customer customer) {
        // Kullanıcı bilgilerini veri tabanından kontrol et
        Optional<Customer> dbUser = customerRepository.findByUsername(customer.getUsername());
        Map<String, Object> response = new HashMap<>();
        if (dbUser != null && Objects.isNull(customer.getPassword())) {
            // Kullanıcı doğrulandı, ana sayfaya yönlendir
            response.put("success", true);
            response.put("redirect", "/");
        } else {
            // Kullanıcı doğrulanamadı, hata mesajı göster
            response.put("success", false);
            response.put("message", "Geçersiz kullanıcı adı veya şifre");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        authDataService.delete(id);

    }


    public CustomerController( CustomUserDetailsManager customUserDetailsManager, AuthDataService authDataService,
                               CustomerRepository customerRepository) {

        this.customUserDetailsManager = customUserDetailsManager;
        this.authDataService = authDataService;

        this.customerRepository = customerRepository;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> createAccount (@RequestBody AccountCreationRequest accountCreationRequest) {


        Customer customer = new Customer();
        customer.setEmail((accountCreationRequest.getEmail()));
        customer.setPassword(accountCreationRequest.getPassword());
        customer.setUsername(accountCreationRequest.getUsername());

        authDataService.createUserProfile(customer);
        return ResponseEntity.ok(new AccountCreationResponse("success", null));
    }

    @GetMapping ("/getAll")
    public List<Customer> findAll(){
        return authDataService.findAll();

    }
    @PutMapping("/customerupdate")
    public Customer update(@RequestBody Customer customer){
        return authDataService.update(customer);
    }


//    @PostMapping("/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(
//            @RequestHeader(value = "Authorization") String headerData) {
//
//        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
//        String[] data = headerData.split(" ");
//        byte[] decode = Base64.getDecoder().decode(data[1]);
//        String decodeStr = new String(decode, StandardCharsets.UTF_8);
//        data = decodeStr.split(":");
//
//        authenticationRequest.setUsername(data[0]);
//        authenticationRequest.setPassword(data[1]);
//
//
//
//    /*   try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
//                            Md5Util.getInstance().getMd5Hash(authenticationRequest.getPassword()))
//            );
//        } catch (BadCredentialsException e) {
//            return ResponseEntity.ok(new AccountCreationResponse(null, "Incorrect username or password"));
//        } catch (Exception e) {
//            return ResponseEntity.ok(new AccountCreationResponse(null, "Username does not exist"));
//        }
//*/
//        final UserDetails userDetails = customUserDetailsManager.loadUserByUsername(authenticationRequest.getUsername());
//
//
//        Customer customer = authDataService.findByUsername(authenticationRequest.getUsername());
//
//        return ResponseEntity.ok(new AuthenticationResponse(null,null, customer.getFirstName()));
//
//
//    }

}



