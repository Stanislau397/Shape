package edu.epam.shape.factory.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.Point2d;
import edu.epam.shape.factory.ShapeFactory;
import edu.epam.shape.validator.EllipseValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EllipseFactory implements ShapeFactory<Ellipse, Point2d> {

    public static final Logger logger = LogManager.getLogger(EllipseFactory.class);

    @Override
    public Ellipse createShape(List<Point2d> points) {
        EllipseValidator validator = new EllipseValidator();
        if (!(validator.isEllipse(points))) {
            logger.log(Level.WARN, "Cannot create Ellipse with given data!");
        }
        Ellipse ellipse = new Ellipse(points.get(0), points.get(1));
        return ellipse;
    }
}
