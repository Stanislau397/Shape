package edu.epam.shape.parser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Double2dListParserTest {

    Double2dListParser parser;

    @BeforeTest
    public void setUp() {
        this.parser = new Double2dListParser();
    }

    @Test
    public void testParseToDouble2dList() {
        List<Double> doubles = Arrays.asList(2.0, 3.0, 4.0, 6.0);
        List<List<Double>> result = parser.parseToDouble2dList("2.0 3.0 4.0 6.0");
        List<List<Double>> expResult = Arrays.asList(doubles);

        assertEquals(result, expResult);
    }

    @Test
    public void testParseToStringArray() {
        String line = "2.0 3.0 4.0 6.0";
        List<String> result = parser.parseToStringArray(line);
        List<String> expResult = new ArrayList<>();
        expResult.add("2.0");
        expResult.add("3.0");
        expResult.add("4.0");
        expResult.add("6.0");

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.parser = null;
    }
}