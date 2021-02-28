package com.dedo.devproj.services;


import com.dedo.devproj.business.service.CustomerService;
import com.dedo.devproj.data.entity.Customer;
import com.dedo.devproj.data.repository.CustomerRepository;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@DisplayName("=== Customer Services Test ===")
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;






    @Test
    @DisplayName("* Service returns new Customer w/ Name *")
    void when_passed_stringName_service_saves_and_returns_customer() {
        String name = "Testing Name";

        Customer customer = customerService.createCustomer(name);


        Assertions.assertNotNull(customer);
        Assertions.assertNotNull(customer.getCustomerCart());
        Assertions.assertTrue(customer.getCustomerCart().getProductSet().isEmpty(), () -> "Product List should be at 0");
        Assertions.assertNotNull(customerRepository.findById(customer.getCustomerId()).get(), () -> "Should be saving to the customer repo");

    }



}
