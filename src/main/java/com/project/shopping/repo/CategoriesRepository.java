package com.project.shopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.shopping.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
    @Query(value = "SELECT * FROM categories where category_name LIKE %:name%", nativeQuery = true)
    public List<Categories> findByName(@Param(value = "name") String categoryName);

}
