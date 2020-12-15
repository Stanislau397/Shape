package edu.epam.figure.validator;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class EllipseValidatorTest {

    EllipseValidator validator;

    @BeforeTest
    public void setUp() {
        validator = new EllipseValidator();
    }

    @Test
    public void testIsValidEllipseTrue() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(3.0);
        coordinates.add(4.0);
        coordinates.add(6.0);

        boolean condition = validator.isValidEllipse(coordinates);
        assertTrue(condition);
    }

    @Test
    public void testIsValidEllipseFalse() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(3.0);
        coordinates.add(3.0);
        coordinates.add(4.0);

        boolean condition = validator.isValidEllipse(coordinates);
        assertFalse(condition);
    }

    @Test
    public void testCanExistTrue() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(3.0);
        coordinates.add(4.0);
        coordinates.add(6.0);

        boolean condition = validator.canExist(coordinates);
        assertTrue(condition);
    }

    @Test
    public void testCanExistFalse() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(6.0);

        boolean condition = validator.canExist(coordinates);
        assertFalse(condition);
    }

    @Test
    public void testIsEqualPointsTrue() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(4.0);
        coordinates.add(2.0);
        coordinates.add(6.0);

        boolean condition = validator.isEqualPoints(coordinates);
        assertTrue(condition);
    }

    @Test
    public void testIsEqualPointsFalse() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(4.0);
        coordinates.add(5.0);
        coordinates.add(6.0);

        boolean condition = validator.isEqualPoints(coordinates);
        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.validator = null;
    }
}