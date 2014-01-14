package com.restaurant;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.order.Order;
import com.order.product.Product;
import com.restaurant.Cashier;
import com.restaurant.Manager;
import com.restaurant.Restaurant;
import com.restaurant.Robot;

public class CashierTest {
    
    private Cashier underTest;
    private Restaurant restaurant;
    private Robot robot;
    private Manager manager;
    
    @Before
    public void setUp() {
        underTest = new Cashier();
        restaurant = EasyMock.createMock(Restaurant.class);
        robot = EasyMock.createMock(Robot.class);
        manager = EasyMock.createMock(Manager.class);
        underTest.setRestaurant(restaurant);
        underTest.setRobot(robot);
    }
    
    @Test
    public void testAcquireAndSetCashier() {
        //Given
        EasyMock.expect(restaurant.getManager()).andReturn(manager);
        manager.incrementNumberOfClients();
        EasyMock.expectLastCall();
        EasyMock.replay(restaurant);
        EasyMock.replay(manager);
        //When
        underTest.acquireAndSetCashier(true);
        underTest.acquireAndSetCashier(false);
        //Then
        EasyMock.verify(restaurant);
        EasyMock.verify(manager);
        Assert.assertFalse(underTest.isAvailable());
    }
    
    @Test
    public void testRecieveAnOrder() {
        //Given
        Order order = new Order(new ArrayList<Product>(), 0f, underTest);
        EasyMock.expect(restaurant.getManager()).andReturn(manager);
        manager.incrementNumberOfOrders();
        EasyMock.expectLastCall();
        robot.addOrder(order);
        EasyMock.expectLastCall();
        EasyMock.replay(robot);
        EasyMock.replay(restaurant);
        EasyMock.replay(manager);
        //When
        underTest.recieveAnOrder(order);
        //Then
        EasyMock.verify(robot);
        EasyMock.verify(restaurant);
        EasyMock.verify(manager);
        Assert.assertEquals(order, underTest.getOrder());
    }

}
