package com.project.shopping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

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

import com.project.shopping.Service.ProductsService;

import com.project.shopping.model.Products;
import com.project.shopping.repo.ProductsRepository;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsService product;
    @Autowired
    ProductsRepository productsRepository;

    @GetMapping("/get")
    public List<Products> getAllProducts() {
        return product.find();
    }

    @GetMapping(value = "/get/{productId}")
    public Optional<Products> getProductsById(@PathVariable("productId") int productId) {
        return product.findOne(productId);

    }

    @GetMapping("/pname")
    public List<Products> pname(@RequestParam(value = "productName") String productName) {
        return product.retriveName(productName);

    }

    @PostMapping("/post")
    public void createProducts(@RequestBody Products produc) {
        product.create(produc);
    }

    @DeleteMapping("/delete/{productid}")
    public void delet(@PathVariable("productid") int id) {
        product.erase(id);
    }

    @PutMapping("/update/{productId}")
    public Products updateByProductId(@PathVariable("productId") int id, @RequestBody Products prod){
        return product.updateById(id,prod);
      }
   

}
