package com.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotDogTest {
    
    private Product underTest;
    
    @Before
    public void setUp() {
        underTest = new HotDog();
    }
    
    @Test
    public void testGetPrice() {
        //Given
        //When
        float actual = underTest.getPrice();
        //Then
        Assert.assertEquals(2.99f, actual);
    }
    
    @Test
    public void testGetPriceWithExtras() {
        //Given
        Extra extra1 = new Mustard();
        underTest.addExtra(extra1);
        //When
        float actual = underTest.getPrice();
        //Then
        Assert.assertEquals(3.74f, actual);
    }
    
    @Test
    public void testRecalculateHappiness() {
        //Given
        //When
        float actual = underTest.getHappiness(20);
        //Then
        Assert.assertEquals(22f, actual);
    }
    
    @Test
    public void testRecalculateHappinessWithExtras() {
        //Given
        Extra extra1 = new Mustard();
        underTest.addExtra(extra1);
        //When
        float actual = underTest.getHappiness(12);
        //Then
        Assert.assertEquals(13f, actual);
    }
    
    @Test
    public void testName() {
        //Given
        //When
        String actual = underTest.getName();
        //Then
        Assert.assertEquals("HotDog", actual);
    }

}
