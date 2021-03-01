package com.dedo.devproj.business.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class CustomerInfo {
    private long customerId;
    private String customerName;
    private long cartId;

    public CustomerInfo() { }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }
}
