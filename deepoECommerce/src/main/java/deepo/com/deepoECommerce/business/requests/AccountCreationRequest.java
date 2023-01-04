package deepo.com.deepoECommerce.business.requests;

import lombok.*;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountCreationRequest {

    private String username;
    private String password;
    private String lastname;
    private String firstname;
    private String email;
    private String repassword;

}
