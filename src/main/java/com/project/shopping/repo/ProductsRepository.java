package com.project.shopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.shopping.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    @Query(value = "SELECT * FROM Products where product_name LIKE %:name%", nativeQuery = true)
    public List<Products> findByName(@Param(value = "name") String ProductName);
}
