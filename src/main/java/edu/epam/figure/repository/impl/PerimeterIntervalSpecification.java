package edu.epam.figure.repository.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;
import edu.epam.figure.repository.EllipseSpecification;

public class PerimeterIntervalSpecification implements EllipseSpecification<Ellipse> {

    private double perimeterFrom;
    private double perimeterTo;

    public PerimeterIntervalSpecification(double perimeterFrom, double perimeterTo) {
        this.perimeterFrom = perimeterFrom;
        this.perimeterTo = perimeterTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        Point2d startPoint = ellipse.getStartPoint();
        Point2d endPoint = ellipse.getEndPoint();

        double majorAxis = Math.abs(startPoint.getX() - endPoint.getX());
        double minorAxis = Math.abs(startPoint.getY() - endPoint.getY());
        int power = 2;

        double perimeter = ((Math.PI * minorAxis * majorAxis) + (Math.pow(minorAxis - majorAxis, power))) * 4;

        return perimeter >= perimeterFrom && perimeter <= perimeterTo;
    }
}
