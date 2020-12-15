package edu.epam.figure.factory;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class EllipseFactoryTest {

    EllipseFactory ellipseFactory;

    @BeforeTest
    public void setUp() {
        this.ellipseFactory = new EllipseFactory();
    }

    @Test
    public void testCreateEllipse() {
        List<String> lines = new ArrayList<>();
        lines.add("2.0 3.0 4.0 6.0");

        List<Ellipse> result = ellipseFactory.createEllipse(lines);
        List<Ellipse> expResult = new ArrayList<>();
        expResult.add(new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0)));

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.ellipseFactory = null;
    }
}