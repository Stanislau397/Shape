package edu.epam.figure.parser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DoubleArrayParserTest {

    Double2dListParser parser;

    @BeforeTest
    public void setUp() {
        this.parser = new Double2dListParser();
    }

    @Test
    public void testParseToDoubleArray() {
        String line = "2.0 3.0 4.0 6.0";
        //List<Double> result = parser.parseToDoubleArray(line);
        List<Double> expResult = new ArrayList<>();
        expResult.add(2.0);
        expResult.add(3.0);
        expResult.add(4.0);
        expResult.add(6.0);

        //assertEquals(result, expResult);
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