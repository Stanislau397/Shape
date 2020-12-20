package edu.epam.figure.validator;

import java.util.List;

public class ArgumentsValidator {

    private static final int ARGUMENTS = 4;

    public boolean isEnoughArguments(List<Double> coordinates) {
        return ARGUMENTS == coordinates.size();
    }
}
