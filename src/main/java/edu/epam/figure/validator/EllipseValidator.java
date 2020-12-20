package edu.epam.figure.validator;

import edu.epam.figure.entity.Point2d;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EllipseValidator {

    public static final Logger logger = LogManager.getLogger(EllipseValidator.class);
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;

    public boolean isEllipse(List<Point2d> points) {
        boolean result = true;
        if (!(isRectangle(points) && isEqualPoints(points))) {
            logger.log(Level.WARN, "Invalid ellipse data!");
            result = false;
        }
        return result;
    }

    public boolean isRectangle(List<Point2d> points) {
        double majorAxis = points.get(INDEX_0).getX() - points.get(INDEX_1).getX();
        double minorAxis = points.get(INDEX_0).getY() - points.get(INDEX_1).getY();

        return (majorAxis != minorAxis);
    }

    public boolean isEqualPoints(List<Point2d> points) {
        boolean condition1 = (points.get(INDEX_0).getX() == points.get(INDEX_1).getX());
        boolean condition2 = (points.get(INDEX_0).getY() == points.get(INDEX_1).getY());

        return (!condition1 || !condition2);
    }
}
