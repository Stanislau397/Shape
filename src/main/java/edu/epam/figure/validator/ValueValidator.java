package edu.epam.figure.validator;

import edu.epam.figure.exception.ValidatorException;

import java.util.regex.Pattern;

public class ValueValidator {

    public static final String REGEX_DOUBLE = "[+-]*((\\d+\\.?\\d*)|(\\d*\\.?\\d+))";

    public boolean isValidLine(String line) throws ValidatorException {
        if (!Pattern.matches(REGEX_DOUBLE, line)) {
            throw new ValidatorException("Invalid line: " + line);
        }
        return true;
    }
}
