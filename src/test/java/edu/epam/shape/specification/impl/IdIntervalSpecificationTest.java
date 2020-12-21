package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.Point2d;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdIntervalSpecificationTest {

    IdIntervalSpecification specification;

    @BeforeTest
    public void setUp() {
        this.specification = new IdIntervalSpecification(1, 5);
    }

    @Test
    public void testSpecifyTrue() {
        Ellipse ellipse1 = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        boolean condition = specification.specify(ellipse1);

        assertTrue(condition);
    }

    @Test
    public void testSpecifyFalse() {
        Ellipse ellipse2 = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        Ellipse ellipse3 = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        Ellipse ellipse4= new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        Ellipse ellipse5 = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        Ellipse ellipse6 = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        Ellipse ellipse7 = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));

        boolean condition = specification.specify(ellipse7);

        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.specification = null;
    }
}