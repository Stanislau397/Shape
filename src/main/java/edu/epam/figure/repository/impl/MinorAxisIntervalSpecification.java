package edu.epam.figure.repository.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;
import edu.epam.figure.repository.EllipseSpecification;

public class MinorAxisIntervalSpecification implements EllipseSpecification<Ellipse> {

    private double minorAxisFrom;
    private double minorAxisTo;

    public MinorAxisIntervalSpecification(double minorAxisFrom, double minorAxisTo) {
        this.minorAxisFrom = minorAxisFrom;
        this.minorAxisTo = minorAxisTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        Point2d startPoint = ellipse.getStartPoint();
        Point2d endPoint = ellipse.getEndPoint();
        double minorAxis = Math.abs(startPoint.getY() - endPoint.getY());

        return minorAxis >= minorAxisFrom && minorAxis <= minorAxisTo;
    }
}
