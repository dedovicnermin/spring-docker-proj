package com.dedo.devproj.business.service;

import com.dedo.devproj.data.entity.Cart;
import com.dedo.devproj.data.entity.Customer;
import com.dedo.devproj.data.repository.CartRepository;
import com.dedo.devproj.data.repository.CustomerRepository;
import com.dedo.devproj.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;




    public Customer createCustomer(String name) {
        Cart cart = new Cart();
        cartRepository.saveAndFlush(cart);

        Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setCustomerCart(cart);
        customerRepository.saveAndFlush(customer);

        return customer;
    }




}
