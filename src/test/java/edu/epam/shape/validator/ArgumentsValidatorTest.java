package edu.epam.shape.validator;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ArgumentsValidatorTest {

    ArgumentsValidator validator;

    @BeforeTest
    public void setUp() {
        this.validator = new ArgumentsValidator();
    }

    @Test
    public void testIsEnoughArgumentsTrue() {
        List<Double> coordinates = Arrays.asList(2.0, 3.0, 4.0, 6.0);
        boolean condition = validator.isEnoughArguments(coordinates);

        assertTrue(condition);
    }

    @Test
    public void testIsEnoughArgumentsFalse() {
        List<Double> coordinates = Arrays.asList(2.0, 3.0);
        boolean condition = validator.isEnoughArguments(coordinates);

        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.validator = null;
    }
}