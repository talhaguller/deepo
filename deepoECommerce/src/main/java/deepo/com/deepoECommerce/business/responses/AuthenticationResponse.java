package deepo.com.deepoECommerce.business.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthenticationResponse {

    private String jwt;
    private String error;
    private String firstName;


}