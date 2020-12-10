package edu.epam.figure.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EllipseValidator {

    public static final Logger logger = LogManager.getLogger(EllipseValidator.class);
    public static final int ELLIPSE_ARGUMENTS = 4;
    public static final int UPPER_LEFT_X = 0;
    public static final int UPPER_LEFT_Y = 1;
    public static final int LOWER_RIGHT_X = 2;
    public static final int LOWER_RIGHT_Y = 3;

    public boolean isValidEllipse(List<Double> coordinates) {
        boolean result = coordinates.size() == ELLIPSE_ARGUMENTS
                && !(coordinates.get(UPPER_LEFT_X).equals(coordinates.get(LOWER_RIGHT_X))
                || coordinates.get(UPPER_LEFT_Y).equals(coordinates.get(LOWER_RIGHT_Y)));

        if (!result) {
            logger.log(Level.DEBUG, "Invalid Data");
        }
        return result;
    }
}
