package com.people;

import com.order.Order;

public class Cashier {

    private boolean available = true;
    private boolean orderFinished = false;
    private Order order;
    private Robot robot = Robot.getInstance();
    private Restaurant restaurant = Restaurant.getInstance();

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        if(available == true) {
            Manager manager = restaurant.getManager();
            manager.incrementNumberOfClients();
        }
        this.available = available;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        if(available == true) {
            Manager manager = restaurant.getManager();
            manager.incrementNumberOfOrders();
        }
        this.order = order;
    }
    
    public void makeOrder() {
        robot.addOrder(order);
    }

    public void setOrderFinished(boolean orderFinished) {
        this.orderFinished = orderFinished;
    }

    public boolean isOrderFinished() {
        return orderFinished;
    }

}
