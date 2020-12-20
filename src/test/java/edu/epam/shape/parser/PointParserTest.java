package edu.epam.shape.parser;

import edu.epam.shape.entity.Point2d;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class PointParserTest {

    PointParser parser;

    @BeforeTest
    public void setUp() {
        this.parser = new PointParser();
    }

    @Test
    public void testParseToPointList() {
        List<String> lines = Arrays.asList("2.0 3.0 4.0 6.0");
        List<Point2d> result = parser.parseToPointList(lines);
        List<Point2d> expResult = new ArrayList<>();
        expResult.add(new Point2d(2.0, 3.0));
        expResult.add(new Point2d(4.0, 6.0));

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.parser = null;
    }
}