package edu.epam.figure.validator;

import edu.epam.figure.constant.IndexConstant;
import edu.epam.figure.exception.ValidatorException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EllipseValidator {

    public static final Logger logger = LogManager.getLogger(EllipseValidator.class);

    public boolean isValidEllipse(List<Double> coordinates) {
        ArgumentsValidator validator = new ArgumentsValidator();

        try {

            return validator.isEnoughArguments(coordinates) && canExist(coordinates) && isEqualPoints(coordinates);

        } catch (ValidatorException e) {
            logger.log(Level.ERROR, e.getMessage());
        }

        return false;
    }

    public boolean canExist(List<Double> coordinates) {
        double majorAxis = coordinates.get(IndexConstant.INDEX_X1) - coordinates.get(IndexConstant.INDEX_X2);
        double minorAxis = coordinates.get(IndexConstant.INDEX_Y1) - coordinates.get(IndexConstant.INDEX_Y2);

        return majorAxis != minorAxis;
    }

    public boolean isEqualPoints(List<Double> coordinates) {
        boolean condition1 = (coordinates.get(IndexConstant.INDEX_X1).equals(coordinates.get(IndexConstant.INDEX_X2)));
        boolean condition2 = (coordinates.get(IndexConstant.INDEX_Y1).equals(coordinates.get(IndexConstant.INDEX_Y2)));

        return !condition1 || !condition2;
    }
}
