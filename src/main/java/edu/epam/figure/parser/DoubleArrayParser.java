package edu.epam.figure.parser;

import edu.epam.figure.exception.ValidatorException;
import edu.epam.figure.validator.ValueValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleArrayParser {

    public static final Logger logger = LogManager.getLogger(DoubleArrayParser.class);
    public static final String REGEX_DELIMITER = "\\s+";

    public List<Double> parseToDoubleArray(String point) {
        List<String> points = parseToStringArray(point);
        List<Double> coordinates = new ArrayList<>();
        ValueValidator valueValidator = new ValueValidator();

        try {

            for (String line : points) {
                if (valueValidator.isValidLine(line)) {
                    coordinates.add(Double.parseDouble(line));
                }
            }
        } catch (ValidatorException e) {
            logger.log(Level.ERROR, e.getMessage());
        }

        return coordinates;
    }

    public List<String> parseToStringArray(String line) {
        return Arrays.asList(line.split(REGEX_DELIMITER));
    }
}
