package com.dedo.devproj.rest;

import com.dedo.devproj.data.entity.Cart;
import com.dedo.devproj.data.entity.Customer;
import com.dedo.devproj.data.repository.CartRepository;
import com.dedo.devproj.data.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/create")
    public Customer createCustomer(@RequestParam String name) {
        Cart cart = new Cart();
        cartRepository.saveAndFlush(cart);


        Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setCustomerCart(cart);
        customerRepository.saveAndFlush(customer);

        return customer;
    }

    



}
