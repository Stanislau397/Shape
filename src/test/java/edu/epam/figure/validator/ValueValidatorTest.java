package edu.epam.figure.validator;

import edu.epam.figure.exception.ValidatorException;
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

    @Test(expectedExceptions = ValidatorException.class)
    public void testIsValidLineTrue() throws ValidatorException {
        boolean condition = validator.isValidLine("4.0 2.0 3.0 5.0");
        assertTrue(condition);
    }

    @Test(expectedExceptions = ValidatorException.class)
    public void testIsValidLineFalse() throws ValidatorException {
        boolean condition = validator.isValidLine("2a 3b 4c 2d");
        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.validator = null;
    }
}