package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.Point2d;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MajorAxisIntervalSpecificationTest {

    MajorAxisIntervalSpecification specification;

    @BeforeTest
    public void setUp() {
        this.specification = new MajorAxisIntervalSpecification(2, 5);
    }

    @Test
    public void testSpecifyTrue() {
        Ellipse ellipse = new Ellipse(new Point2d(6.0, 2.0), new Point2d(2.0, 4.0));
        boolean condition = specification.specify(ellipse);

        assertTrue(condition);
    }

    @Test
    public void testSpecifyFalse() {
        Ellipse ellipse = new Ellipse(new Point2d(3.0, 4.0), new Point2d(4.0, 6.0));
        boolean condition = specification.specify(ellipse);

        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.specification = null;
    }
}