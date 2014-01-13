package com.order;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderBuilderTest {
    
    private OrderBuilder underTest;
    
    @Before
    public void setUp() {
        underTest = new OrderBuilder();
    }
    
    @Test
    public void testGetOrder() {
        //Given
        Order expected = new Order(new ArrayList<Product>(), 0f);
        //When
        Order actual = underTest.getOrder();
        //Then
        Assert.assertEquals(expected.getOrder(), actual.getOrder());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }
    
    @Test
    public void testAddOrder() {
        //Given
        ArrayList<Product> list = new ArrayList<Product>();
        HotDog woof = new HotDog();
        list.add(woof);
        Order expected = new Order(list, 2.99f);
        //When
        Order actual = underTest.addProduct(woof).getOrder();
        //Then
        Assert.assertEquals(expected.getOrder(), actual.getOrder());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }
    
    @Test
    public void testImplementDiscount() {
        //Given
        ArrayList<Product> list = new ArrayList<Product>();
        HotDog woof = new HotDog();
        list.add(woof);
        Order expected = new Order(list, 1.495f);
        //When
        Order actual = underTest.addProduct(woof).implementDiscount(50).getOrder();
        //Then
        Assert.assertEquals(expected.getOrder(), actual.getOrder());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }
    
    @Test
    public void testClear() {
        //Given
        ArrayList<Product> list = new ArrayList<Product>();
        HotDog woof = new HotDog();
        Order expected = new Order(list, 0f);
        //When
        Order actual = underTest.addProduct(woof).implementDiscount(50).clear().getOrder();
        //Then
        Assert.assertEquals(expected.getOrder(), actual.getOrder());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

}
