package com.project.shopping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopping.model.Categories;
import com.project.shopping.repo.CategoriesRepository;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository category;

    public void create(Categories categorie) {
        category.save(categorie);
    }

    public List<Categories> retrive() {
        return category.findAll();
    }

    public Optional<Categories> retriveOne(int categoryId) {
        return category.findById(categoryId);
    }

    public List<Categories> getName(String CategoryName) {
        return category.findByName(CategoryName);
    }

    public void delete(int id) {
        category.deleteById(id);
    }

    public Categories updateById(int id, Categories categoryupdate) {
        Optional<Categories> categoryId=category.findById(id);
        if(categoryId.isPresent()){
            Categories categoryUpdate=categoryId.get();
          categoryUpdate.setCategoryName(categoryupdate.getCategoryName());
       
            return(category.save(categoryUpdate));

        }
        else{
            return null;
        }
    }
}
