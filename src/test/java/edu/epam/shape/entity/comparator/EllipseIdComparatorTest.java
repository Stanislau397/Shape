package edu.epam.shape.entity.comparator;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.Point2d;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EllipseIdComparatorTest {

    EllipseIdComparator comparator;

    @BeforeTest
    public void setUp() {
        this.comparator = new EllipseIdComparator();
    }

    @Test
    public void testCompare() {
        Ellipse ellipse1 = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        Ellipse ellipse2 = new Ellipse(new Point2d(4.0, 6.0), new Point2d(6.0, 7.0));

        int result = comparator.compare(ellipse1, ellipse2);
        int expResult = 1;
    }

    @AfterTest
    public void tierDown() {
        this.comparator = null;
    }
}