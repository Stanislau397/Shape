package edu.epam.shape.util;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdGeneratorTest {

    @Test
    public void testGenerateId() {
        long result = IdGenerator.generateId();
        long expResult = 1;

        assertEquals(result, expResult);
    }
}