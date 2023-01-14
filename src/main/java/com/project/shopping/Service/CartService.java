package com.project.shopping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopping.model.Cart;
import com.project.shopping.repo.CartRepository;

@Service
public class CartService {
    @Autowired
    CartRepository cart;

    public void create(Cart ca) {
        cart.save(ca);
    }

    public List<Cart> getall() {
        return cart.findAll();
    }

    public Optional<Cart> getOne(int cartId) {
        return cart.findById(cartId);
    }

    public void erase(int cartId) {
        cart.deleteById(cartId);
    }

}
