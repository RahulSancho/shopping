package com.project.shopping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopping.model.Invoice;
import com.project.shopping.repo.InvoiceRepository;

@Service
public class InvoiceService {
   @Autowired
   InvoiceRepository invoice;

   public void create(Invoice invoic) {
      invoice.save(invoic);
   }

   public Optional<Invoice> getId(int invoic) {
      return invoice.findById(invoic);
   }

   public List<Invoice> getall() {
      return invoice.findAll();
   }

   public void erase(int id) {
      invoice.deleteById(id);
   }
}
