package edu.epam.figure.repository.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;
import edu.epam.figure.repository.EllipseSpecification;

public class SquareIntervalSpecification implements EllipseSpecification<Ellipse> {

    private double squareFrom;
    private double squareTo;

    public SquareIntervalSpecification(double squareFrom, double squareTo) {
        this.squareFrom = squareFrom;
        this.squareTo = squareTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        Point2d startPoint = ellipse.getStartPoint();
        Point2d endPoint = ellipse.getEndPoint();
        double majorAxis = Math.abs(startPoint.getX() - endPoint.getX());
        double minorAxis = Math.abs(startPoint.getY() - endPoint.getY());

        double ellipseSquare = (Math.PI * majorAxis * minorAxis) / 4;

        return ellipseSquare >= squareFrom && ellipseSquare <= squareTo;
    }
}
