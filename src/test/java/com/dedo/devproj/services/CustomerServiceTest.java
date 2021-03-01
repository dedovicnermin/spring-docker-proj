package com.dedo.devproj.services;


import com.dedo.devproj.business.domain.CustomerInfo;
import com.dedo.devproj.business.service.CustomerService;
import com.dedo.devproj.data.entity.Cart;
import com.dedo.devproj.data.entity.Customer;
import com.dedo.devproj.data.entity.Product;
import com.dedo.devproj.data.repository.CartRepository;
import com.dedo.devproj.data.repository.CustomerRepository;
import com.dedo.devproj.data.repository.ProductRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.lang.instrument.UnmodifiableClassException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("=== Customer Services Test ===")
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;








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


    @Test
    @DisplayName("* Service returns all customers in unmodifiable list *")
    void service_will_return_unmodifiable_list() {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();
        cartRepository.saveAndFlush(cart1);
        cartRepository.saveAndFlush(cart2);
        cartRepository.saveAndFlush(cart3);

        Customer customer1 = new Customer();
        customer1.setCustomerName("Custy1");
        customer1.setCustomerCart(cart1);
        customerRepository.saveAndFlush(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerName("Custy2");
        customer2.setCustomerCart(cart2);
        customerRepository.saveAndFlush(customer2);

        Customer customer3 = new Customer();
        customer3.setCustomerName("Custy3");
        customer3.setCustomerCart(cart3);
        customerRepository.saveAndFlush(customer3);

        List<Customer> customerList = customerService.getAllCustomers();

        try {
            customerList.add(new Customer());
            fail("Should not be able to modify this list.");
        } catch (Exception e) {
            //pass
        }
    }

    @Test
    @DisplayName("return Customer Info with all fields present")
    void customerInfoIsValid() {
        Cart cart = new Cart();
        cartRepository.saveAndFlush(cart);


        Customer customer1 = new Customer();
        customer1.setCustomerName("Custy1");
        customer1.setCustomerCart(cart);
        customerRepository.saveAndFlush(customer1);


        CustomerInfo expected = new CustomerInfo();
        expected.setCartId(cart.getCartId());
        expected.setCustomerName(customer1.getCustomerName());
        expected.setCustomerId(customer1.getCustomerId());

        CustomerInfo actual = customerService.getCustomerInfo(customer1.getCustomerId());

        assertTrue(expected.equals(actual));

    }


    @Test
    @DisplayName("Retrieving product will get the product or return a new Product")
    void test_product_returns_existent_product_or_fresh() {
        Product product1 = new Product();

        product1.setProductName("FUNKO");
        product1.setProductPrice(12.99);
        productRepository.saveAndFlush(product1);

        Product productActual = productRepository.findById(product1.getProductId()).get();
        assertEquals(product1, productActual);

        try {
            Product productActual2 = productRepository.findById(500l).get();
        } catch (Exception e) {
            //pass
        }



    }




}
