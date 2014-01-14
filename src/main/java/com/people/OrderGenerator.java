package com.people;

import java.util.Random;

import com.order.Chips;
import com.order.HotDog;
import com.order.Ketchup;
import com.order.Mustard;
import com.order.Order;
import com.order.OrderBuilder;
import com.order.Product;

public class OrderGenerator {
    
    private boolean doneOrdering = false;
    private Random random = new Random();
    private OrderBuilder builder;
    private Order order;
    
    public Order generateRandomOrder(OrderBuilder orderBuilder) {
        builder = orderBuilder.addProduct(generateARandomFood());
        makeRandomActions();
        return order;
    }
    
    public void makeRandomActions() {
        int randomNumber;
        while (!doneOrdering) {
            randomNumber = random.nextInt(100);
            if(randomNumber < 75) {
                builder = builder.addProduct(generateARandomFood());
            }
            
            if(randomNumber > 74 && randomNumber < 90) {
                order = builder.getOrder();
                doneOrdering = true;
            }
            
            if(randomNumber > 89 && randomNumber < 95) {
                builder = builder.implementDiscount(10);
            }
            if(randomNumber > 94 && randomNumber < 100) {
                builder = builder.clear();
                order = builder.getOrder();
                doneOrdering = true;
            }
        }
    }

    @SuppressWarnings("null")
    public Product generateARandomFood() {
        Product answer = null;
        int randomFoodNumber = random.nextInt(2);
        int randomExtraNumber = random.nextInt(4);
        if(randomFoodNumber == 0) {
            answer = new HotDog();
        }
        
        if(randomFoodNumber == 1) {
            answer = new Chips();
        }
        
        if(randomExtraNumber / 2 == 1) {
            answer.addExtra(new Ketchup());
        }
        if(randomExtraNumber % 2 == 1) {
            answer.addExtra(new Mustard());
        }
        return answer;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void setBuilder(OrderBuilder builder) {
        this.builder = builder;
    }

    public OrderBuilder getBuilder() {
        return builder;
    }

    public Order getOrder() {
        return order;
    }

}
