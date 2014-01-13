package com.order;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MustardTest {
    
    private Extra underTest;
    
    @Before
    public void setUp() {
        underTest = new Mustard();
    }
    
    @Test
    public void testConstructor() {
        //Given
        //When
        String actualAnswer = underTest.getName();
        //Then
        Assert.assertEquals("Mustard", actualAnswer);
    }
    
    @Test
    public void testRecalculateHappiness() {
        //Given
        //When
        int actualAnswer = underTest.recalculateHappiness(EasyMock.anyInt());
        //Then
        Assert.assertEquals(1, actualAnswer);
    }

}
