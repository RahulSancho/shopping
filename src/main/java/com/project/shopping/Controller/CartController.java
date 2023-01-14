package com.project.shopping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopping.Service.CartService;
import com.project.shopping.model.Cart;
import com.project.shopping.repo.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cart;
    @Autowired
    CartRepository cartRepository;

    @PostMapping("/post")
    public void createCart(@RequestBody Cart car) {
        cart.create(car);

    }

    @GetMapping("/get")
    public List<Cart> find() {
        return cart.getall();
    }

    @GetMapping("/get/{cartId}")
    public Optional<Cart> retrive(@PathVariable int cartId) {
        return cart.getOne(cartId);

    }

    @DeleteMapping("/delete/{cartId}")
    public void delete(@PathVariable int cartId) {
        cart.erase(cartId);
    }

    

}
