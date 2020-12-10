package edu.epam.figure.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class ValueValidator {

    public static final Logger logger = LogManager.getLogger(ValueValidator.class);
    public static final String REGEX_DOUBLE = "([+-]?((\\d+\\.?\\d*)" +
            "|(\\d*\\.?\\d+))([\\s]+|))*";

    public boolean isValidLine(String line) {
        boolean result = Pattern.matches(REGEX_DOUBLE, line);

        if (!result) {
            logger.log(Level.DEBUG, "Invalid digit");
        }
        return result;
    }
}
