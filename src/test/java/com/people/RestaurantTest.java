package com.people;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestaurantTest {
    
    private Restaurant underTest;
    
    @Before
    public void setUp() {
        underTest = Restaurant.getInstance();
    }
    
    @Test
    public void testSingleton() {
        //Given
        Restaurant otherRestaurant = Restaurant.getInstance();
        //When
        //Then
        Assert.assertEquals(otherRestaurant, underTest);
        Assert.assertEquals(otherRestaurant.getCashiers(), underTest.getCashiers());
        Assert.assertEquals(otherRestaurant.getManager(), underTest.getManager());
    }

}
