package edu.epam.figure.validator;

import edu.epam.figure.exception.ValidatorException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ArgumentsValidatorTest {

    ArgumentsValidator validator;

    @BeforeTest
    public void setUp() {
        this.validator = new ArgumentsValidator();
    }

    @Test(expectedExceptions = ValidatorException.class)
    public void testIsEnoughArgumentsFalse() throws ValidatorException {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);

        boolean condition = validator.isEnoughArguments(coordinates);
        assertFalse(condition);
    }

    @Test(expectedExceptions = ValidatorException.class)
    public void testIsEnoughArgumentsTrue() throws ValidatorException {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(4.0);
        coordinates.add(3.0);
        coordinates.add(3.0);

        boolean condition = validator.isEnoughArguments(coordinates);
        assertTrue(condition);
    }

    @AfterTest
    public void tierDown() {
        this.validator = null;
    }
}