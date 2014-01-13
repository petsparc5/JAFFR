package com.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KetchupTest {
    
    private Extra underTest;
    
    @Before
    public void setUp() {
        underTest = new Ketchup();
    }
    
    @Test
    public void testConstructor() {
        //Given
        //When
        String actualAnswer = underTest.getName();
        //Then
        Assert.assertEquals("Ketchup", actualAnswer);
    }
    
    @Test
    public void testRecalculateHappinessWithAZeroHappinessLevel() {
        //Given
        //When
        int actualAnswer = underTest.recalculateHappiness(0);
        //Then
        Assert.assertEquals(0, actualAnswer);
    }
    
    @Test
    public void testRecalculateHappinessWithANonZeroHappinessLevel() {
        //Given
        //When
        int actualAnswer = underTest.recalculateHappiness(20);
        //Then
        Assert.assertEquals(40, actualAnswer);
    }

}
