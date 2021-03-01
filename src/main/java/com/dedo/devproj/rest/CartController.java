package com.dedo.devproj.rest;

import com.dedo.devproj.business.service.CustomerService;
import com.dedo.devproj.data.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/")
    public List<Cart> getCarts() {
        return customerService.getAllCarts();
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable long id) {
        return customerService.getCustomerCart(id);
    }






}
