package com.dedo.devproj.rest;

import com.dedo.devproj.business.domain.CustomerInfo;
import com.dedo.devproj.business.service.CustomerService;
import com.dedo.devproj.data.entity.Cart;
import com.dedo.devproj.data.entity.Customer;
import com.dedo.devproj.data.repository.CartRepository;
import com.dedo.devproj.data.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create")
    public Customer createCustomer(@RequestParam String name) {
        return customerService.createCustomer(name);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }


    @GetMapping("/{id}")
    public CustomerInfo getCustomerInfo(@PathVariable long id) {
        return customerService.getCustomerInfo(id);
    }














}
