package com.order;

import java.util.ArrayList;
import java.util.List;

import com.order.extra.Extra;
import com.order.product.Product;
import com.restaurant.Cashier;

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Product product : order) {
            builder.append(" Product: ").append(product.getName()).append("%n");
            for (Extra extra : product.getExtras()) {
                builder.append(" Extra: ").append(extra.getName()).append("%n");
            }
        }
        return builder.toString();
    }
    
    
}
