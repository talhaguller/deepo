package deepo.com.deepoECommerce.business.abstracts;

        import deepo.com.deepoECommerce.entities.concretes.Admin;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public interface AdminService {

    List<Admin> findAll();

    Optional<Admin> findById(int id);
    Admin save(Admin admin);
    Admin update(Admin admin);
    void delete(int id);


}
