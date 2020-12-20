package edu.epam.shape.validator;

import edu.epam.shape.entity.Point2d;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EllipseValidator {

    public static final Logger logger = LogManager.getLogger(EllipseValidator.class);

    public boolean isEllipse(List<Point2d> points) {
        boolean result = isRectangle(points) && isNotEqualPointX(points) && isNotEqualPointY(points);

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

    public boolean isNotEqualPointX(List<Point2d> points) {
        Point2d pointX1 = points.get(0);
        Point2d pointX2 = points.get(1);

        return (pointX1.getX() != pointX2.getX());
    }

    public boolean isNotEqualPointY(List<Point2d> points) {
        Point2d pointY1 = points.get(0);
        Point2d pointY2 = points.get(1);

        return (pointY1.getY() != pointY2.getY());
    }
}
