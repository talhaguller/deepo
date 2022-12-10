package deepo.com.deepoECommerce.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomerResponse {
    private int customer_id;




    private String username;

    private String email;

    private String password;

    private String rePassword;

    private String role;

    private boolean enabled;

}
