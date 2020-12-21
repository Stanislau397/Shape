package edu.epam.shape.parser;

import edu.epam.shape.validator.ValueValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleListOfListsParser {

    public static final Logger logger = LogManager.getLogger(DoubleListOfListsParser.class);
    public static final String REGEX_DELIMITER = "\\s+";

    public List<List<Double>> parseToDoubleListOfLists(String point) {
        List<String> points = parseToStringArray(point);
        List<Double> doubles = new ArrayList<>();
        List<List<Double>> coordinates = new ArrayList<>();
        ValueValidator valueValidator = new ValueValidator();

        for (String line : points) {

            if (valueValidator.isDoubleLine(line)) {
                doubles.add(Double.parseDouble(line));
            } else {
                logger.log(Level.WARN, "Cannot parse point! {}", line);
            }
        }
        coordinates.add(doubles);
        return coordinates;
    }

    public List<String> parseToStringArray(String line) {
        return Arrays.asList(line.split(REGEX_DELIMITER));
    }
}
