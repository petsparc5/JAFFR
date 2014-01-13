package com.order;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    
    private List<Product> order = new ArrayList<>();
    private float price = 0;
    
    public OrderBuilder addProduct(Product product) {
        order.add(product);
        price += product.getPrice();
        return this;
    }

    public Order getOrder() {
        return new Order(order, price);
    }
    
    public OrderBuilder implementDiscount(float percentage) {
        price = price * (1 - percentage/100);
        return this;
    }
    
    public OrderBuilder clear() {
        order = new ArrayList<>();
        price = 0;
        return this;     
    }
}
