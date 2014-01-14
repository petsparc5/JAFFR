package com.people;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.order.Order;
import com.order.Product;

public class RobotTest {
    
    private Robot underTest;
    
    @Before
    public void setUp() {
        underTest = Robot.getInstance();
    }
    
    @Test
    public void testSingleton() {
        //Given
        Robot otherRobot = Robot.getInstance();
        //When
        //Then
        Assert.assertEquals(otherRobot, underTest);
    }
    
    @Test
    public void testAddOrder() {
        //Given
        Order expected = new Order(new ArrayList<Product>(), 0f, new Cashier());
        
        //When
        underTest.addOrder(expected);
        //Then
        Order actual = underTest.getOrderQueue().poll();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrepareOrder() {
        //Given
        Order order = new Order(new ArrayList<Product>(), 0f, new Cashier());
        underTest.addOrder(order);
        //When
        underTest.prepareOrder();
        //Then
        int actual = underTest.getOrderQueue().size();
        Assert.assertEquals(0, actual);
    }
    
    @Test
    public void testRun() {
        //Given
        Order order = new Order(new ArrayList<Product>(), 0f, new Cashier());
        underTest.addOrder(order);
        underTest.addOrder(order);
        underTest.addOrder(order);
        Thread thread = new Thread(underTest);
        //When
        thread.start();
        stopThread();
        //Then
        int actual = underTest.getOrderQueue().size();
        Assert.assertEquals(0, actual);
    }
    
    public void stopThread() {
        boolean flag = true;
        while (flag) {
            if(underTest.getOrderQueue().size() == 0) {
                flag = false;
                underTest.setAmSlaving(false);
            }
        }
    }

}
