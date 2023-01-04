package deepo.com.deepoECommerce.dataAccess.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    @Query(value = "SELECT customer_id, username, first_name, last_name, email, password " +
            "FROM customer where username = :USERNAME ",
            nativeQuery = true)
    Optional<Customer> findByUsername(@Param("USERNAME") String USERNAME);

    @Query(value = "SELECT customer_id, username, first_name, last_name, email, password " +
            "FROM customer where email = :EMAIL ",
            nativeQuery = true)
    Optional<Customer> findByEmail(@Param("EMAIL") String EMAIL);


    @Query(value = "DELETE FROM customer where username = :USERNAME and password = :PASSWORD",
            nativeQuery = true)
    void deleteByUsernamePassword(@Param("USERNAME") String USERNAME, @Param("PASSWORD") String PASSWORD);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customer (username,  password,first_name,last_name,email,re_password) " +
            " VALUES (:USERNAME,  :PASSWORD,:FIRSTNAME,:LASTNAME,:EMAIL, :REPASSWORD )", nativeQuery = true)
    void createUserProfile(@Param("USERNAME") String USERNAME, @Param("FIRSTNAME") String FIRSTNAME,
                           @Param("LASTNAME") String LASTNAME, @Param("EMAIL") String EMAIL,
                           @Param("PASSWORD") String PASSWORD ,@Param("REPASSWORD") String REPASSWORD) ;


}

