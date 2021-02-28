package com.dedo.devproj.data;

import com.dedo.devproj.NermPostgresqlContainer;
import com.dedo.devproj.data.entity.Cart;
import com.dedo.devproj.data.entity.Customer;
import com.dedo.devproj.data.repository.CartRepository;
import com.dedo.devproj.data.repository.CustomerRepository;
import com.dedo.devproj.data.repository.ProductRepository;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.persistence.EntityManager;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;



@DisplayName("--- Customer Table Testing ---")
@SpringBootTest
@Slf4j
public class DataTests {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = NermPostgresqlContainer.getInstance();


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;




//    CUSTOMER

    @Test
    void customer_can_be_saved_test() {
        Customer customer = new Customer();
        customer.setCustomerName("YAYAYA");


       customerRepository.saveAndFlush(customer);
       log.info(customer.toString());


        assertThat(customerRepository.findById(customer.getCustomerId()).get()).isEqualTo(customer);

    }

    @Test
    void customer_update_will_persist_and_show_test() {
        Customer customer = new Customer();
        customer.setCustomerName("ToChange");

        customerRepository.saveAndFlush(customer);
        assertThat(customerRepository.findById(customer.getCustomerId()).get()).isEqualTo(customer);

        customer.setCustomerName("ChangedName");
        customerRepository.saveAndFlush(customer);

        assertThat(customerRepository.findById(customer.getCustomerId()).get()).isEqualTo(customer);
    }


    @Test
    void customerToCartAssociationTest() {
        Cart cart = new Cart();
        cartRepository.saveAndFlush(cart);

        Customer customer = new Customer();
        customer.setCustomerName("Nermin Dedovic");
        customer.setCustomerCart(cart);
        customerRepository.saveAndFlush(customer);

        long customerId = customer.getCustomerId();
        Cart cart1 = customer.getCustomerCart();

        Assertions.assertEquals(customerRepository.findById(customerId).get().getCustomerCart(), cart1, () -> "The customer from the cutomerRepo should return the same cart.");
    }














}
