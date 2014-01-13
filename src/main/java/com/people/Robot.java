package com.people;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.order.Order;

public class Robot{
    private static final Robot INSTANCEOFROBOT;
    private static Queue<Order> orderQueue; 
    
    static {
        INSTANCEOFROBOT = new Robot();
        orderQueue = new ConcurrentLinkedQueue<>();
    }

    private Robot() {}

    public static Robot getInstance() {
        return INSTANCEOFROBOT;
    }

    public void addOrder(Order order) {
        System.out.println(order.toString()+" is added to the FIFO");
        orderQueue.add(order);
    }

    public void prepareOrder() {
        if(orderQueue.size() > 0){
            Order order = orderQueue.poll(); 
            System.out.println("Order: " + order.toString() + "prepared");
            //order.getCashier().orderFinished();
        }
    }
}
