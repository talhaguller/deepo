package deepo.com.deepoECommerce.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    private String productName;
    private int supplierId;
    private int categoryId;
    private double unitPrice;
    private int unitsInStock;
    private int discontinued;
}
