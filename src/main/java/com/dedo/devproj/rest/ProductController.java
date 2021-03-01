package com.dedo.devproj.rest;

import com.dedo.devproj.business.service.CustomerService;
import com.dedo.devproj.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/add")
    public String addProduct(@RequestParam String prodName, @RequestParam double price) {
        return customerService.addProduct(prodName, price);
    }


    @GetMapping("/")
    public List<Product> getProducts() {
        return customerService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
        return customerService.getProduct(id);
    }





}
