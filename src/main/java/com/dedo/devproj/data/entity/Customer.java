package com.dedo.devproj.data.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "CUSTOMER")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_id;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customer_name;

    @Column(name = "CUSTOMER_CART")
    private long customer_cart;




}
