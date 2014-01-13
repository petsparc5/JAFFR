package com.order;

import java.util.ArrayList;
import java.util.List;

import com.people.Cashier;

public class OrderBuilder {
    
    private List<Product> order = new ArrayList<>();
    private float price = 0;
    private Cashier cashier;

    public OrderBuilder(Cashier cashier) {
        super();
        this.cashier = cashier;
    }

    public OrderBuilder addProduct(Product product) {
        order.add(product);
        price += product.getPrice();
        return this;
    }

    public Order getOrder() {
        return new Order(order, price, cashier);
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
