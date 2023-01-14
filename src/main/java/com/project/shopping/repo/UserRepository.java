package com.project.shopping.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.shopping.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
  List<Users> findByname(String name);

  @Query(value = "SELECT * FROM users where name LIKE %:name%", nativeQuery = true)
  public List<Users> findByName(@Param(value = "name") String Name);

  Optional<Users> findByEmail(String email);

}
