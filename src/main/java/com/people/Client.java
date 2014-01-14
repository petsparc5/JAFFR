package com.people;

import java.util.List;

import com.order.Order;
import com.order.OrderBuilder;
import com.order.Product;

public class Client implements Runnable {

    private Cashier cashier;
    private Order order;
    private boolean clientFinished = false;
    private float happinessLevel = 200;
    private float money = 200;
    private OrderGenerator generator = new OrderGenerator();

    @Override
    public void run() {
        lookForCashier();
        makeAnOrder();
        if (!clientFinished) {
            waitForFood();
        }
        consumeFood();
    }

    private void lookForCashier() {
        while (cashier == null) {
            Restaurant restaurant = Restaurant.getInstance();
            List<Cashier> cashiers = restaurant.getCashiers();
            for (Cashier nextCashier : cashiers) {
                if (nextCashier.isAvailable()) {
                    cashier = nextCashier;
                    cashier.acquireAndSetCashier(false);
                }

            }
            if(cashier == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Could not sleep while waiting for a cashier");
                }
            }
        }
    }

    private void makeAnOrder() {
        OrderBuilder builder = new OrderBuilder(cashier);
        order = generator.generateRandomOrder(builder);
        if (order.getOrder().isEmpty()) {
            clientFinished = true;
        } else {
            cashier.recieveAnOrder(order);
        }

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

    private void consumeFood() {
        List<Product> list = order.getOrder();
        for (Product product : list) {
            happinessLevel = product.getHappiness(happinessLevel);
        }
        money -= order.getPrice();
        cashier.setOrderFinished(false);
        cashier.acquireAndSetCashier(true);
        clientFinished = true;
        System.out.println("" + money);
    }

    public void setGenerator(OrderGenerator generator) {
        this.generator = generator;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isClientFinished() {
        return clientFinished;
    }

    public float getHappinessLevel() {
        return happinessLevel;
    }

    public float getMoney() {
        return money;
    }
}
