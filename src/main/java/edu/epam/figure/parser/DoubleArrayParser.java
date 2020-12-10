package edu.epam.figure.parser;

import edu.epam.figure.validation.ValueValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleArrayParser {

    public static final String REGEX_DELIMITER = "\\s+";

    public List<Double> parseToDoubleArray(String linesPoints) {
        List<String> points = parseToStringArray(linesPoints);
        List<Double> coordinates = new ArrayList<>();
        ValueValidator valueValidator = new ValueValidator();

        for (String lines : points) {
            if (valueValidator.isValidLine(lines)) {
                coordinates.add(Double.parseDouble(lines));
            }
        }
        return coordinates;
    }

    public List<String> parseToStringArray(String lines) {
        return Arrays.asList(lines.split(REGEX_DELIMITER));

    }
}
