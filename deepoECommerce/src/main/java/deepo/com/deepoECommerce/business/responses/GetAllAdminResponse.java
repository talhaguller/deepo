package deepo.com.deepoECommerce.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllAdminResponse {

    private int admin_id;

    private String username;

    private String email;

    private String password;

    private boolean enabled;


}
