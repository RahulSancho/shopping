package com.project.shopping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopping.Service.PaymentsService;
import com.project.shopping.model.Payments;
import com.project.shopping.repo.PaymentsRepository;

@RestController
@RequestMapping("/payment")
public class PaymentsController {
  @Autowired
  PaymentsService payments;
  @Autowired
  PaymentsRepository paymentsRepository;

  @PostMapping("/post")
  public void createPayment(@RequestBody Payments payment) {
    payments.create(payment);
  }

  @GetMapping("/get/{paymentId}")
  public Optional<Payments> getId(@PathVariable("paymentId") int paymentId) {
    return payments.getId(paymentId);

  }

  @GetMapping("/get")
  public List<Payments> get() {
    return payments.getall();
  }

  @DeleteMapping("/delete/paymentid")
  public void delete(@PathVariable("id") int id) {
    payments.erase(id);
  }

  @PutMapping("/update/{orderId}")
  public Payments updateByPaymentId(@PathVariable("paymentId") int id, @RequestBody Payments payment){
    return payments.updateById(id,payment);
  }
  
}
