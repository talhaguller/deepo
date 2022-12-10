package deepo.com.deepoECommerce.business.abstracts;

import deepo.com.deepoECommerce.entities.concretes.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role findByRole(String role);
}
