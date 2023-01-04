package deepo.com.deepoECommerce.webApi.controllers;

import deepo.com.deepoECommerce.business.abstracts.AdminService;
import deepo.com.deepoECommerce.entities.concretes.Admin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/Admin")
@AllArgsConstructor

public class AdminController {

    private final AdminService adminService;

    @GetMapping ("/getAll")
    public List<Admin> findAll(){
        return adminService.findAll();

    }
    @GetMapping("/{id}")
    public Optional<Admin> findById(@PathVariable("id") int id){
    return adminService.findById(id);

    }
    @PostMapping
    public Admin save(@RequestBody Admin admin){

        return adminService.save(admin);
    }
    @PutMapping
    public Admin update(@RequestBody Admin admin){
        return adminService.update(admin);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        adminService.delete(id);
    }

    }

