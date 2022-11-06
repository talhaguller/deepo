package deepo.com.deepoECommerce.entities.concretes;


import lombok.*;

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
    private int product_id;

    @Column(name ="product_name")
    private String product_name;
    private int supplier_id;
    private int category_id;
    private double unit_price;
    private int units_in_stock;
    private int discontinued;
}

