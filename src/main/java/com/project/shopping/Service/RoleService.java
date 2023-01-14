package com.project.shopping.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopping.model.Role;
import com.project.shopping.repo.RoleRepository;

@Service
public class RoleService {
    @Autowired
    RoleRepository role;

    public void create(Role use) {
        role.save(use);
    }

    public Optional<Role> retriveOne(int userId) {
        return role.findById(userId);
    }
}
