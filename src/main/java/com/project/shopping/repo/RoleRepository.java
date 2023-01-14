package com.project.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopping.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
