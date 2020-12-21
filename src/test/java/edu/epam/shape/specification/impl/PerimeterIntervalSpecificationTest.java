package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.EllipseData;
import edu.epam.shape.entity.EllipseWareHouse;
import edu.epam.shape.entity.Point2d;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PerimeterIntervalSpecificationTest {

    PerimeterIntervalSpecification specification;
    EllipseWareHouse wareHouse;

    @BeforeTest
    public void setUp() {
        this.specification = new PerimeterIntervalSpecification(1.0, 80.0);
        this.wareHouse = EllipseWareHouse.getInstance();
    }

    @Test
    public void testSpecifyTrue() {
        Ellipse ellipse = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        EllipseData data = new EllipseData(25.0, 40.0);
        wareHouse.put(ellipse.getEllipseId(), data);
        boolean condition = specification.specify(ellipse);

        assertTrue(condition);
    }

    @Test
    public void testSpecifyFalse() {
        Ellipse ellipse = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        EllipseData data = new EllipseData(100.0, 100.0);
        wareHouse.put(ellipse.getEllipseId(), data);
        boolean condition = specification.specify(ellipse);

        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.specification = null;
    }
}