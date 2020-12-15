package edu.epam.figure.util;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {

    DataReader dataReader;
    static final String PATH = "file";

    @BeforeTest
    public void setUp() {
        this.dataReader = new DataReader();
    }

    @Test
    public void testReadDataFromFile() {
        List<String> result = dataReader.readDataFromFile(PATH);
        List<String> expResult = new ArrayList<>();
        expResult.add("2.0 3.0 4.0 6.0");

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.dataReader = null;
    }
}