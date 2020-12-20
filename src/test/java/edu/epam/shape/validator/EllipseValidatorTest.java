package edu.epam.shape.validator;

import edu.epam.shape.entity.Point2d;
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
        this.validator = new EllipseValidator();
    }

    @Test
    public void testIsEllipseTrue() {
        List<Point2d> points = new ArrayList<>();
        points.add(new Point2d(2.0, 3.0));
        points.add(new Point2d(4.0, 6.0));

        boolean condition = validator.isEllipse(points);

        assertTrue(condition);
    }

    @Test
    public void testIsEllipseFalse() {
        List<Point2d> points = new ArrayList<>();
        points.add(new Point2d(2.0, 3.0));
        points.add(new Point2d(2.0, 6.0));

        boolean condition = validator.isEllipse(points);

        assertFalse(condition);
    }

    @Test
    public void testIsRectangleTrue() {
        List<Point2d> points = new ArrayList<>();
        points.add(new Point2d(2.0, 3.0));
        points.add(new Point2d(4.0, 6.0));

        boolean condition = validator.isRectangle(points);

        assertTrue(condition);
    }

    @Test
    public void testIsRectangleFalse() {
        List<Point2d> points = new ArrayList<>();
        points.add(new Point2d(2.0, 2.0));
        points.add(new Point2d(3.0, 3.0));

        boolean condition = validator.isRectangle(points);

        assertFalse(condition);
    }

    @Test
    public void testIsNotEqualPointXTrue() {
        List<Point2d> points = new ArrayList<>();
        points.add(new Point2d(2.0, 2.0));
        points.add(new Point2d(3.0, 3.0));

        boolean condition = validator.isNotEqualPointX(points);

        assertTrue(condition);
    }

    @Test
    public void testIsNotEqualPointXFalse() {
        List<Point2d> points = new ArrayList<>();
        points.add(new Point2d(2.0, 2.0));
        points.add(new Point2d(2.0, 3.0));

        boolean condition = validator.isNotEqualPointX(points);

        assertFalse(condition);
    }

    @Test
    public void testIsNotEqualPointYTrue() {
        List<Point2d> points = new ArrayList<>();
        points.add(new Point2d(2.0, 3.0));
        points.add(new Point2d(4.0, 6.0));

        boolean condition = validator.isNotEqualPointY(points);

        assertTrue(condition);
    }

    @Test
    public void testIsNotEqualPointYFalse() {
        List<Point2d> points = new ArrayList<>();
        points.add(new Point2d(2.0, 3.0));
        points.add(new Point2d(4.0, 3.0));

        boolean condition = validator.isNotEqualPointY(points);

        assertFalse(condition);
    }

    @AfterTest
    public void tierDown() {
        this.validator = null;
    }
}