package deepo.com.deepoECommerce.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductResponse {

    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private double unitPrice;
    private int unitsInStock;
    private int discontinued;
}
