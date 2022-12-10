package deepo.com.deepoECommerce.dataAccess.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepesitory extends JpaRepository<Role,Integer> {
    Role findByRole(String role);
}
