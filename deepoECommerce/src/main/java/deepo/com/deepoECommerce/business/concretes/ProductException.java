package deepo.com.deepoECommerce.business.concretes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
public class ProductException {
    private static final long serialVersionUID = 1L;

    @Autowired
    private HttpStatus errorStatus;
    @Autowired
    private String errorMessage;


    public HttpStatus getErrorStatus() {
        return errorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
