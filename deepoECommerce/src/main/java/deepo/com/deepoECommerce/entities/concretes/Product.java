package deepo.com.deepoECommerce.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Collection;

import javax.persistence.*;

@Table(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id")
    private int productId;

    @Column(name ="product_name")
    private String productName;

    @Column(name = "suppolier_id")
    private int supplierId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "discontinued")
    private int discontinued;






}
