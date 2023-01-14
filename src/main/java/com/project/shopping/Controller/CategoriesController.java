package com.project.shopping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopping.Service.CategoriesService;
import com.project.shopping.model.Categories;
import com.project.shopping.repo.CategoriesRepository;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    CategoriesService categories;
    @Autowired
    private CategoriesRepository categoriesRepository;

    @PostMapping("/post")
    public void createCategory(@RequestBody Categories category) {
        categories.create(category);
    }

    @GetMapping("/get")
    public List getAllCategories() {
        return categories.retrive();
    }

    @GetMapping(value = "/get/{categoryId}")
    public Optional<Categories> getCategoriesById(@PathVariable("categoryId") int categoryId) {
        return categories.retriveOne(categoryId);

    }

    @GetMapping("/name")
    public List<Categories> name(@RequestParam(value = "categoryName") String categoryName) {
        return categories.getName(categoryName);
    }

    @DeleteMapping("/delete/{categoryid}")
    public void deletee(@PathVariable("categoryid") int id) {
        categories.delete(id);
    }

    @PutMapping("/update/{categoryId}")
    public Categories updateByCategorytId(@PathVariable("categoryId") int id, @RequestBody Categories category){
        return categories.updateById(id,category);
      }
   
}
