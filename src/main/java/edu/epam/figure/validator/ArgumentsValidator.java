package edu.epam.figure.validator;

import edu.epam.figure.exception.ValidatorException;

import java.util.List;

public class ArgumentsValidator {

    private static final int ARGUMENTS = 4;

    public boolean isEnoughArguments(List<Double> coordinates) throws ValidatorException {
        if (!(coordinates.size() == ARGUMENTS)) {
            throw new ValidatorException("Not enough arguments!");
        }
        return true;
    }
}
