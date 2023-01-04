package deepo.com.deepoECommerce.business.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthenticationRequest {

    private String username;
    private String password;

}

