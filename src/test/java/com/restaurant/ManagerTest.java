package com.restaurant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.restaurant.Manager;

public class ManagerTest {
    
    private Manager underTest;
    
    @Before
    public void setUp() {
        underTest = new Manager();
    }
    
    @Test
    public void testIncrementNumberOfClients() {
        //Given
        //When
        underTest.incrementNumberOfClients();
        underTest.incrementNumberOfClients();
        //Then
        Assert.assertEquals(2, underTest.getNumberOfClients());
    }
    
    @Test
    public void testIncrementNumberOfOrders() {
        //Given
        //When
        underTest.incrementNumberOfOrders();
        underTest.incrementNumberOfOrders();
        underTest.incrementNumberOfOrders();
        underTest.incrementNumberOfOrders();
        underTest.incrementNumberOfOrders();
        //Then
        Assert.assertEquals(5, underTest.getNumberOfOrders());
    }

}
