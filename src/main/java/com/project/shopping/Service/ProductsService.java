package com.project.shopping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopping.model.Products;
import com.project.shopping.repo.ProductsRepository;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository products;

    public void create(Products product) {
        products.save(product);
    }

    public List<Products> find() {
        return products.findAll();
    }

    public Optional<Products> findOne(int productId) {
        return products.findById(productId);
    }

    public List<Products> retriveName(String ProductName) {
        return products.findByName(ProductName);
    }

    public void erase(int id) {
        products.deleteById(id);
    }

    public Products updateById (int id, Products prod){
        Optional<Products> productId=products.findById(id);
        if(productId.isPresent()){
            Products productUpdate=productId.get();
            productUpdate.setProductName(prod.getProductName());
            productUpdate.setProductPrice(prod.getProductPrice());
            productUpdate.setCategoryId(prod.getCategoryId());
            return(products.save(productUpdate));

        }
        else{
            return null;
        }
    }



}
