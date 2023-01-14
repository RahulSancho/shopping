package com.project.shopping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopping.model.Payments;
import com.project.shopping.repo.OrdersRepository;
import com.project.shopping.repo.PaymentsRepository;

@Service
public class PaymentsService {
    @Autowired

    PaymentsRepository payment;
    @Autowired
    OrdersRepository ordersRepository;

    public void create(Payments payments) {

        payment.save(payments);
    }

    public Optional<Payments> getId(int paymentId) {
        return payment.findById(paymentId);
    }

    public List<Payments> getall() {
        return payment.findAll();
    }

    public void erase(int id) {
        payment.deleteById(id);
    }

    public Payments updateById(int id, Payments pay) {
        Optional<Payments> paymentId=payment.findById(id);
        if(paymentId.isPresent()){
            Payments paymentUpdate=paymentId.get();
            paymentUpdate.setDate(pay.getDate());
           paymentUpdate.setPaymentMode(pay.getPaymentMode());
            return(payment.save(paymentUpdate));

        }
        else{
            return null;
        }
        
    }

  
  

}
