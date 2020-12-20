package edu.epam.figure.factory.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;
import edu.epam.figure.factory.ShapeFactory;
import edu.epam.figure.validator.EllipseValidator;

import java.util.List;

public class EllipseFactory implements ShapeFactory<Ellipse, Point2d> {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;

    @Override
    public Ellipse createShape(List<Point2d> points) {
        EllipseValidator validator = new EllipseValidator();
        Ellipse ellipse = null;
        if (validator.isEllipse(points)) {
            ellipse = new Ellipse(points.get(INDEX_0), points.get(INDEX_1));
        }
        return ellipse;
    }
}
