package edu.epam.shape.factory.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.Point2d;
import edu.epam.shape.factory.ShapeFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class EllipseFactoryTest {

    EllipseFactory factory;

    @BeforeTest
    public void setUp() {
        this.factory = new EllipseFactory();
    }

    @Test
    public void testCreateShape() {
        List<Point2d> points = new ArrayList<>();
        points.add(new Point2d(2.0, 3.0));
        points.add(new Point2d(4.0, 6.0));

        Ellipse result = factory.createShape(points);
        Ellipse expResult = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.factory = null;
    }
}