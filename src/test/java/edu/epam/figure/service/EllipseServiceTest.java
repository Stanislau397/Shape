package edu.epam.figure.service;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseServiceTest {

    EllipseService ellipseService;

    @BeforeTest
    public void setUp() {
        this.ellipseService = EllipseService.getInstance();
    }

    @Test
    public void testCalcSquareOfEllipse() {
        Ellipse ellipse = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        double result = ellipseService.calcSquareOfEllipse(ellipse);
        double expResult = 4.71238898038469;

        assertEquals(result, expResult);
    }

    @Test
    public void testCalcPerimeterOfEllipse() {
        Ellipse ellipse = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        double result = ellipseService.calcPerimeterOfEllipse(ellipse);
        double expResult = 79.39822368615503;

        assertEquals(result, expResult);
    }

    @Test
    public void testIsCircleTrue() {
        Ellipse ellipse = new Ellipse(new Point2d(4.0, 2.0), new Point2d(6.0, 4.0));
        boolean condition = ellipseService.isCircle(ellipse);

        assertTrue(condition);
    }

    @Test
    public void testIsCircleFalse() {
        Ellipse ellipse = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        boolean condition = ellipseService.isCircle(ellipse);

        assertFalse(condition);
    }

    @Test
    public void testIsCrossOxTrue() {
        Ellipse ellipse = new Ellipse(new Point2d(-6.5, 4), new Point2d(-2, 0));
        boolean condition = ellipseService.isCrossOx(ellipse);

        assertTrue(condition);
    }

    @Test
    public void testIsCrossOxFalse() {
        Ellipse ellipse = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        boolean condition = ellipseService.isCrossOx(ellipse);

        assertFalse(condition);
    }

    @Test
    public void testIsCrossOyTrue() {
        Ellipse ellipse = new Ellipse(new Point2d(-4.0, 6.0), new Point2d(0.0, 2));
        boolean condition = ellipseService.isCrossOy(ellipse);

        assertTrue(condition);
    }

    @Test
    public void testIsCrossOyFalse() {
        Ellipse ellipse = new Ellipse(new Point2d(-6.5, 4), new Point2d(-2, 0));
        boolean condition = ellipseService.isCrossOy(ellipse);

        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.ellipseService = null;
    }
}