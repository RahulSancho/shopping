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

import com.project.shopping.Service.InvoiceService;
import com.project.shopping.model.Invoice;
import com.project.shopping.repo.InvoiceRepository;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
  @Autowired
  InvoiceService invoice;
  @Autowired
  InvoiceRepository invoiceRepository;

  @PostMapping("/post")
  public void createInvoice(@RequestBody Invoice invoi) {
    invoice.create(invoi);
  }

  @GetMapping(value = "/get/{invoiceId}")
  public Optional<Invoice> get(@PathVariable("invoiceId") int invoiceId) {
    return invoice.getId(invoiceId);
  }

  @GetMapping("/get")
  public List<Invoice> get() {
    return invoice.getall();
  }

  @DeleteMapping("/delete/invoiceId")
  public void delete(@PathVariable("id") int id) {
    invoice.erase(id);
  }

  
}
