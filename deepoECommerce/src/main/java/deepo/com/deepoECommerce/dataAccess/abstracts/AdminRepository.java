package deepo.com.deepoECommerce.dataAccess.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin,Integer> {



}
