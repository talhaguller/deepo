package deepo.com.deepoECommerce.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name="Admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int admin_id;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String  username;

}
