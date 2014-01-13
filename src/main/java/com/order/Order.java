package com.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private List<Product> order = new ArrayList<>();
    private float price;
    
    public Order(List<Product> order, float price) {
        super();
        this.order = order;
        this.price = price;
    }

    public List<Product> getOrder() {
        return order;
    }

    public float getPrice() {
        return price;
    }
    
    
}
