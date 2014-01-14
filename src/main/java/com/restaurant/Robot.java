package com.restaurant;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.order.Order;

public class Robot implements Runnable {
    private static final Robot INSTANCE_OF_ROBOT;
    private static Queue<Order> orderQueue;
    private volatile boolean amSlaving = true;
    private int mealsPrepared = 0;

    static {
        INSTANCE_OF_ROBOT = new Robot();
        orderQueue = new ConcurrentLinkedQueue<>();
    }

    private Robot() {
    }

    public static Robot getInstance() {
        return INSTANCE_OF_ROBOT;
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }

    public void prepareOrder() {
        if (orderQueue.size() > 0) {
            Order order = orderQueue.poll();
            mealsPrepared++;
            System.out.println("OrderNumber: " + mealsPrepared);
            System.out.format(order.toString() + "%n");
            order.getCashier().setOrderFinished(true);
        }
    }

    public void setAmSlaving(boolean amSlaving) {
        this.amSlaving = amSlaving;
    }

    @Override
    public void run() {
        while (amSlaving) {
            prepareOrder();
        }
    }

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }
}
