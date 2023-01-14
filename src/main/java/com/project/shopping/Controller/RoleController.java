package com.project.shopping.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopping.Service.RoleService;
import com.project.shopping.model.Role;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService role;

    @PostMapping("/post")
    public void createRole(@RequestBody Role admi) {
        role.create(admi);

    }

    @GetMapping(value = "/ge/{userId}")
    public Optional<Role> roleById(@PathVariable("userId") int userId) {
        return role.retriveOne(userId);

    }
}
