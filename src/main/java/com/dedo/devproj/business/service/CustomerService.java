package com.dedo.devproj.business.service;

import com.dedo.devproj.business.domain.CustomerInfo;
import com.dedo.devproj.data.entity.Cart;
import com.dedo.devproj.data.entity.Customer;
import com.dedo.devproj.data.entity.Product;
import com.dedo.devproj.data.repository.CartRepository;
import com.dedo.devproj.data.repository.CustomerRepository;
import com.dedo.devproj.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return Collections.unmodifiableList(customerList);
    }

    public CustomerInfo getCustomerInfo(long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        CustomerInfo info = new CustomerInfo();

        info.setCustomerId(customer.getCustomerId());
        info.setCustomerName(customer.getCustomerName());
        info.setCartId(customer.getCustomerCart().getCartId());

        return info;
    }



    public List<Cart> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return Collections.unmodifiableList(carts);
    }

    public Cart getCustomerCart(long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return customer.getCustomerCart();
    }






    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return Collections.unmodifiableList(products);
    }

    public Product getProduct(long productId) {
        Product product = productRepository.findById(productId).orElse(new Product());
        return product;
    }













}
