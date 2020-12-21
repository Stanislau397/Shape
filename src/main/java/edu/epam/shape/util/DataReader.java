package edu.epam.shape.util;

import edu.epam.shape.exception.FileIsEmptyException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    public static final Logger logger = LogManager.getLogger(DataReader.class);

    public List<String> readDataFromFile(String path) throws FileIsEmptyException {
        List<String> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            linesList = br.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new FileIsEmptyException("file is empty");
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        return linesList;
    }
}
