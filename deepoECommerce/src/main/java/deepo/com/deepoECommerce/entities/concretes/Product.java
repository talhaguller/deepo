package deepo.com.deepoECommerce.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "product_title")
    private String product_title;

    @Column(name = "product_main_image_url")
    private String product_main_image_url;

    @Column(name = "app_sale_price")
    private String app_sale_price;

    @Column(name = "app_sale_price_currency")
    private String app_sale_price_currency;

    @Column(name = "product_detail_url")
    private String product_detail_url;

    @Column(name = "evaluate_rate")
    private String evaluate_rate;

    @Column(name = "original_price")
    private String original_price;

    @Column(name = "is_best_seller")
    private boolean is_best_seller;

    @Column(name = "is_prime")
    private boolean is_prime;


}
