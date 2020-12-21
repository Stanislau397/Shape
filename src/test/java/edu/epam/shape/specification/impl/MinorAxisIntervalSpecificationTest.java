package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.Point2d;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinorAxisIntervalSpecificationTest {

    MinorAxisIntervalSpecification specification;

    @BeforeTest
    public void setUp() {
        this.specification = new MinorAxisIntervalSpecification(1, 5);
    }

    @Test
    public void testSpecifyTrue() {
        Ellipse ellipse = new Ellipse(new Point2d(5.0, 6.0), new Point2d(4.0, 4.0));
        boolean condition = specification.specify(ellipse);

        assertTrue(condition);
    }

    @Test
    public void testSpecifyFalse() {
        Ellipse ellipse = new Ellipse(new Point2d(4.0, 6.0), new Point2d(4.0, 6.0));
        boolean condition = specification.specify(ellipse);

        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.specification = null;
    }
}