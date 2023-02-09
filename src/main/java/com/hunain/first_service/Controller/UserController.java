package com.hunain.first_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hunain.first_service.Model.User;
import com.hunain.first_service.Repository.IUserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserRepository userRepo;
    
    @PostMapping
    public void saveUser(@RequestBody User user){
        this.userRepo.save(user);
    }

    @GetMapping("/all")
    public List<User> getAllUser(){
        return this.userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return this.userRepo.findById(id).orElse(null);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        this.userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        String uri = "http://localhost:8081/order/all/"+id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);
        this.userRepo.deleteById(id);
    }
}
