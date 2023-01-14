package com.project.shopping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopping.model.Orders;
import com.project.shopping.repo.OrdersRepository;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository order;

    public void create(Orders use) {
        order.save(use);
    }

    public List<Orders> getall() {
        return order.findAll();

    }

    public Optional<Orders> getOne(int orderId) {
        return order.findById(orderId);
    }

    public void erase(int id) {
        order.deleteById(id);
    }

}
