package com.project.shopping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopping.Service.UserService;

import com.project.shopping.model.Users;
import com.project.shopping.repo.UserRepository;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService user;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/post")
    public void createUser(@RequestBody Users admi) {
        user.create(admi);

    }

    @GetMapping("/get")
    public List<Users> getAllUsers() {
        return user.retrive();
    }

    @GetMapping(value = "/get/{userId}")
    public Optional<Users> getUserById(@PathVariable("userId") int userId) {
        return user.retriveOne(userId);

    }

    @GetMapping("/names")
    public List<Users> name(@RequestParam(value = "name") String name) {
        return user.getName(name);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable int userId) {
        user.delete(userId);
    }

    // @PutMapping("/update/{userId}")
    // public Users updateByUserId(@PathVariable("userId") int id, @RequestBody Users updateuser){
    //     return user.updateById(id,updateuser);
    //   }

}
