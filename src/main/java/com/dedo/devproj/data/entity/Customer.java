package com.dedo.devproj.data.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "CUSTOMER")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cart")
    private Cart customerCart;




}
