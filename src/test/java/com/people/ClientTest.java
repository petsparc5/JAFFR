package com.people;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.order.HotDog;
import com.order.Order;
import com.order.OrderBuilder;
import com.order.Product;

public class ClientTest {
    
    private Client underTest;
    private OrderGenerator generator;
    private Cashier cashier;
    
    @Before
    public void setUp() {
        underTest = new Client();
        generator = EasyMock.createMock(OrderGenerator.class);
        cashier = EasyMock.createMock(Cashier.class);
        underTest.setGenerator(generator);
        Restaurant restaurant = Restaurant.getInstance();
        List<Cashier> cashiers = restaurant.getCashiers();
        setUpCashiers(cashiers);
        cashiers.set(5, cashier);
    }
    
    @Test
    public void testRun() {
        //Given
        ArrayList<Product> orderList = new ArrayList<Product>();
        orderList.add(new HotDog());
        Order order = new Order(orderList, 25f, cashier);
        EasyMock.expect(cashier.isAvailable()).andReturn(false);
        EasyMock.expect(cashier.isAvailable()).andReturn(true);
        cashier.acquireAndSetCashier(false);
        EasyMock.expectLastCall();
        EasyMock.expect(generator.generateRandomOrder(EasyMock.anyObject(OrderBuilder.class))).andReturn(order);
        cashier.recieveAnOrder(order);
        EasyMock.expectLastCall();
        EasyMock.expect(cashier.isOrderFinished()).andReturn(false);
        EasyMock.expect(cashier.isOrderFinished()).andReturn(true);
        cashier.setOrderFinished(false);
        EasyMock.expectLastCall();
        cashier.acquireAndSetCashier(true);
        EasyMock.expectLastCall();
        EasyMock.replay(cashier);
        EasyMock.replay(generator);
        //When
        underTest.run();
        //Then
        EasyMock.verify(cashier);
        EasyMock.verify(generator);
        Assert.assertEquals(order, underTest.getOrder());
        Assert.assertEquals(202f, underTest.getHappinessLevel());
        Assert.assertEquals(175f, underTest.getMoney());
        Assert.assertTrue(underTest.isClientFinished());
    }
    
    @Test
    public void testRunForAngryClient() {
        //Given
        ArrayList<Product> orderList = new ArrayList<Product>();
        Order order = new Order(orderList, 0f, cashier);
        EasyMock.expect(cashier.isAvailable()).andReturn(false);
        EasyMock.expect(cashier.isAvailable()).andReturn(true);
        cashier.acquireAndSetCashier(false);
        EasyMock.expectLastCall();
        EasyMock.expect(generator.generateRandomOrder(EasyMock.anyObject(OrderBuilder.class))).andReturn(order);
        cashier.setOrderFinished(false);
        EasyMock.expectLastCall();
        cashier.acquireAndSetCashier(true);
        EasyMock.expectLastCall();
        EasyMock.replay(cashier);
        EasyMock.replay(generator);
        //When
        underTest.run();
        //Then
        EasyMock.verify(cashier);
        EasyMock.verify(generator);
        Assert.assertEquals(order, underTest.getOrder());
        Assert.assertEquals(200f, underTest.getHappinessLevel());
        Assert.assertEquals(200f, underTest.getMoney());
        Assert.assertTrue(underTest.isClientFinished());
    }
    
    private void setUpCashiers(List<Cashier> cashiers) {
        for (int i = 0; i < 10; i++) {
            if(i != 5) {
                Cashier cashier = cashiers.get(i);
                cashier.setAvailable(false);
            }
        }
    }

}
