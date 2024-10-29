package com.example.productservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SampleTestFile {

    @Test
    void testOnePlusOneIsTwo(){
        //3 A's of writing unit test
        // Arrange, act, asset

        int i =1 + 1 ;// Arrange + act
        assertEquals(2, i);  //assertion
        assertNotEquals(3,i);

    }
}

/*
Arrange - Create input for testing
Act - call required functions
Assert - check output against expected output

IN the assert function, the first value should be expected, followed by actual value
 */
