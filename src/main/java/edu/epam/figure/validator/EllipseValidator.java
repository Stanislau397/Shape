package edu.epam.figure.validator;

import edu.epam.figure.entity.Point2d;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EllipseValidator {

    public static final Logger logger = LogManager.getLogger(EllipseValidator.class);

    public boolean isEllipse(List<Point2d> points) {
        boolean result = isRectangle(points) && isNotEqualMajorAxis(points) && isNotEqualMinorAxis(points);
        if (!result) {
            logger.log(Level.WARN, "Invalid ellipse data!");
            result = false;
        }
        return result;
    }

    public boolean isRectangle(List<Point2d> points) {
        double majorAxis = points.get(0).getX() - points.get(1).getX();
        double minorAxis = points.get(0).getY() - points.get(1).getY();

        return (majorAxis != minorAxis);
    }

    public boolean isNotEqualMajorAxis(List<Point2d> points) {
        boolean result = (points.get(0).getX() != points.get(1).getX());

        return result;
    }

    public boolean isNotEqualMinorAxis(List<Point2d> points) {
        boolean result = (points.get(0).getY() != points.get(1).getY());

        return result;
    }
}
