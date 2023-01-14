package com.project.shopping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopping.Service.OrdersService;
import com.project.shopping.model.Orders;
import com.project.shopping.repo.OrdersRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrdersService orderService;
    @Autowired
    OrdersRepository ordersRepository;

    @PostMapping("/post")
    public void createObject(@RequestBody Orders order) {
        orderService.create(order);

    }

    @GetMapping("/get")
    public List<Orders> find() {
        return orderService.getall();
    }

    @GetMapping(value = "/get/{orderId}")
    public Optional<Orders> get(@PathVariable("orderId") int orderId) {
        return orderService.getOne(orderId);
    }

    @DeleteMapping("/delete/{orderid}")
    public void delete(@PathVariable("orderid") int id) {
        orderService.erase(id);
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<Object> update(
            @PathVariable("orderId") Integer orderId, @RequestBody Orders orders) {
        Optional<Orders> order = ordersRepository.findById(orderId);
        if (order.isPresent()) {
            Orders _orders = order.get();

            _orders.setAmount(orders.getAmount());
            _orders.setDate(orders.getDate());
        

            return new ResponseEntity<>(ordersRepository.save(_orders), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}