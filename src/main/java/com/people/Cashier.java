package com.people;

import com.order.Order;

public class Cashier {

    private boolean available = true;
    private boolean orderFinished = false;
    private Order order;
    private Robot robot = Robot.getInstance();
    private Restaurant restaurant = Restaurant.getInstance();

    public void acquireAndSetCashier(boolean available) {
        if(available == true) {
            Manager manager = restaurant.getManager();
            manager.incrementNumberOfClients();
        }
        setAvailable(available);
    }

    public void recieveAnOrder(Order order) {
        if(available == true) {
            Manager manager = restaurant.getManager();
            manager.incrementNumberOfOrders();
        }
        setOrder(order);
        robot.addOrder(order);
    }
    
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
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

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
