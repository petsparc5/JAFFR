package com.client;

import java.util.ArrayList;
import java.util.Random;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.client.OrderGenerator;
import com.order.Order;
import com.order.OrderBuilder;
import com.order.product.Product;
import com.restaurant.Cashier;

public class OrderGeneratorTest {
    
    private OrderGenerator underTest;
    private OrderBuilder builder;
    private Random random;
    
    @Before
    public void setUp() {
        underTest = new OrderGenerator();
        random = EasyMock.createMock(Random.class);
        underTest.setRandom(random);
    }
    
    @Test
    public void testGenerateARandomFood() {
        //Given
        EasyMock.expect(random.nextInt(2)).andReturn(1);
        EasyMock.expect(random.nextInt(4)).andReturn(1);
        EasyMock.replay(random);
        //When
        Product product = underTest.generateARandomFood();
        //Then
        EasyMock.verify(random);
        Assert.assertEquals("Chips", product.getName());
        Assert.assertEquals(2.74f, product.getPrice());
        Assert.assertEquals(1, product.getExtras().size());
        Assert.assertEquals(0.75f, product.getExtras().get(0).getPrice());
        Assert.assertEquals("Mustard", product.getExtras().get(0).getName());
    }
    
    @Test
    public void testMakeRandomActionsToGenerateASingelOrder() {
        //Given
        builder = EasyMock.createMock(OrderBuilder.class);
        underTest.setBuilder(builder);
        Cashier cashier = new Cashier();
        Order order = new Order(new ArrayList<Product>(), 0f, cashier);
        EasyMock.expect(random.nextInt(100)).andReturn(1);
        EasyMock.expect(random.nextInt(2)).andReturn(0);
        EasyMock.expect(random.nextInt(4)).andReturn(0);
        EasyMock.expect(builder.addProduct(EasyMock.anyObject(Product.class))).andReturn(builder);
        EasyMock.expect(random.nextInt(100)).andReturn(75);
        EasyMock.expect(builder.getOrder()).andReturn(order);
        EasyMock.replay(random);
        EasyMock.replay(builder);
        //When
        underTest.makeRandomActions();
        //Then
        EasyMock.verify(random);
        EasyMock.verify(builder);
        Assert.assertEquals(order, underTest.getOrder());
    }
    
    @Test
    public void testMakeRandomActionsForDiscounts() {
        //Given
        builder = EasyMock.createMock(OrderBuilder.class);
        underTest.setBuilder(builder);
        Cashier cashier = new Cashier();
        Order order = new Order(new ArrayList<Product>(), 0f, cashier);
        EasyMock.expect(random.nextInt(100)).andReturn(91);
        EasyMock.expect(builder.implementDiscount(10f)).andReturn(builder);
        EasyMock.expect(random.nextInt(100)).andReturn(75);
        EasyMock.expect(builder.getOrder()).andReturn(order);
        EasyMock.replay(random);
        EasyMock.replay(builder);
        //When
        underTest.makeRandomActions();
        //Then
        EasyMock.verify(random);
        EasyMock.verify(builder);
        Assert.assertEquals(order, underTest.getOrder());
    }
    
    @Test
    public void testMakeRandomActionsForClear() {
        //Given
        builder = EasyMock.createMock(OrderBuilder.class);
        underTest.setBuilder(builder);
        Cashier cashier = new Cashier();
        Order order = new Order(new ArrayList<Product>(), 0f, cashier);
        EasyMock.expect(random.nextInt(100)).andReturn(99);
        EasyMock.expect(builder.clear()).andReturn(builder);
        EasyMock.expect(builder.getOrder()).andReturn(order);
        EasyMock.replay(random);
        EasyMock.replay(builder);
        //When
        underTest.makeRandomActions();
        //Then
        EasyMock.verify(random);
        EasyMock.verify(builder);
        Assert.assertEquals(order, underTest.getOrder());
    }
    
    @Test
    public void testGenerateRandomOrder() {
        //Given
        builder = EasyMock.createMock(OrderBuilder.class);
        Cashier cashier = new Cashier();
        Order order = new Order(new ArrayList<Product>(), 0f, cashier);
        EasyMock.expect(random.nextInt(2)).andReturn(1);
        EasyMock.expect(random.nextInt(4)).andReturn(3);
        EasyMock.expect(builder.addProduct(EasyMock.anyObject(Product.class))).andReturn(builder);
        EasyMock.expect(random.nextInt(100)).andReturn(99);
        EasyMock.expect(builder.clear()).andReturn(builder);
        EasyMock.expect(builder.getOrder()).andReturn(order);
        EasyMock.replay(random);
        EasyMock.replay(builder);
        //When
        Order actual = underTest.generateRandomOrder(builder);
        //Then
        EasyMock.verify(random);
        EasyMock.verify(builder);
        Assert.assertEquals(order, actual);
    }

}
