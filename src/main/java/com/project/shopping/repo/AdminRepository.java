package com.project.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopping.model.Users;

@Repository
public interface AdminRepository extends JpaRepository<Users, Integer> {

}
