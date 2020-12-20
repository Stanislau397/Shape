package edu.epam.shape.validator;

import java.util.regex.Pattern;

public class ValueValidator {

    public static final String REGEX_DOUBLE = "[+-]*((\\d+\\.?\\d*)|(\\d*\\.?\\d+))";

    public boolean isDoubleLine(String line) {
        return Pattern.matches(REGEX_DOUBLE, line);
    }
}
