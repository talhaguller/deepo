package deepo.com.deepoECommerce.business.concretes;

import deepo.com.deepoECommerce.business.abstracts.AdminService;
import deepo.com.deepoECommerce.dataAccess.abstracts.AdminRepository;
import deepo.com.deepoECommerce.entities.concretes.Admin;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AdminManager implements AdminService {

    @Autowired
    private final AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findById(int id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin update(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void delete(int id) {
        adminRepository.deleteById(id);
    }



}