package com.order;

import java.util.ArrayList;
import java.util.List;

import com.people.Cashier;

public class Order {
    
    private List<Product> order = new ArrayList<>();
    private float price;
    private Cashier cashier;

    public Order(List<Product> order, float price, Cashier cashier) {
        super();
        this.order = order;
        this.price = price;
        this.cashier = cashier;
    }

    public List<Product> getOrder() {
        return order;
    }

    public float getPrice() {
        return price;
    }

    public Cashier getCashier() {
        return cashier;
    }
    
    
}
