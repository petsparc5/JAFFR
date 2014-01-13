package com.people;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.order.Order;

public class Robot implements Runnable{
    private static final Robot INSTANCE_OF_ROBOT;
    private static Queue<Order> orderQueue; 
    private boolean amSlaving = true;
    
    static {
        INSTANCE_OF_ROBOT = new Robot();
        orderQueue = new ConcurrentLinkedQueue<>();
    }

    private Robot() {}

    public static Robot getInstance() {
        return INSTANCE_OF_ROBOT;
    }

    public void addOrder(Order order) {
        System.out.println(order.toString()+" is added to the FIFO");
        orderQueue.add(order);
    }

    public void prepareOrder() {
        if(orderQueue.size() > 0){
            Order order = orderQueue.poll(); 
            System.out.println("Order: " + order.toString() + "prepared");
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
}
