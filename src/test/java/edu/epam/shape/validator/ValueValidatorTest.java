package edu.epam.shape.validator;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValueValidatorTest {

    ValueValidator validator;

    @BeforeTest
    public void setUp() {
        this.validator = new ValueValidator();
    }

    @Test
    public void testIsDoubleLineTrue() {
        String line = "2.0";
        boolean condition = validator.isDoubleLine(line);

        assertTrue(condition);
    }

    @Test
    public void testIsDoubleLineFalse() {
        String line = "a 3b 4c 6t";
        boolean condition = validator.isDoubleLine(line);

        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.validator = null;
    }
}