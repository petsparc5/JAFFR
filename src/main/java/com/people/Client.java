package com.people;

import java.util.List;
import java.util.Random;

import com.order.HotDog;
import com.order.Order;
import com.order.OrderBuilder;
import com.order.Product;

public class Client implements Runnable {

    private Cashier cashier;
    private boolean doneOrdering = false;
    private Order order;
    private boolean clientFinished = false;
    private float happinessLevel;
    private float money;

    @Override
    public void run() {
        lookForCashier();
        makeAnOrder();
        if(!clientFinished) {
            waitForFood();
            consumeFood();
        }
    }

    private void consumeFood() {
        List<Product> list = order.getOrder();
        for (Product product : list) {
            happinessLevel = product.getHappiness(happinessLevel);
        }
        money -= order.getPrice();
        cashier.setOrderFinished(false);
        cashier.setAvailable(true);
        clientFinished = true;
        System.out.println("" + money);
    }

    private void waitForFood() {
        while (!cashier.isOrderFinished()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Could not wait for food");
            }
        }
        
    }

    public void lookForCashier() {
        while (cashier != null) {
            Restaurant restaurant = Restaurant.getInstance();
            List<Cashier> cashiers = restaurant.getCashiers();
            for (Cashier nextCashier : cashiers) {
                if (nextCashier.isAvailable()) {
                    cashier = nextCashier;
                    cashier.setAvailable(false);
                }

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Could not sleep while waiting for a cashier");
            }
        }
    }

    public void makeAnOrder() {
        Random random = new Random();
        OrderBuilder builder = new OrderBuilder(cashier);
        int randomNumber;
        builder = builder.addProduct(new HotDog());
        while (!doneOrdering) {
            randomNumber = random.nextInt(100);
            if(randomNumber < 75) {
                builder = builder.addProduct(new HotDog());
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
                doneOrdering = true;
            }
        }
        if(order.getOrder().isEmpty()) {
            clientFinished = true;
        } else {
            cashier.setOrder(order);
        }
        
    }
}
