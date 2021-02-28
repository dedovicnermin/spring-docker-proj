package com.dedo.devproj.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CART")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    private long cartId;


//    @Column(name = "CART_CUSTOMER")
//    private Customer cartCustomer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "fk_cart") },
            inverseJoinColumns = {@JoinColumn(name = "fk_product")}
    )
    private Set<Product> productSet = new HashSet<>();





}
