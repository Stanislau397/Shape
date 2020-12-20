package edu.epam.figure.specification.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;
import edu.epam.figure.specification.EllipseSpecification;

public class MajorAxisIntervalSpecification implements EllipseSpecification<Ellipse> {

    private double majorAxisFrom;
    private double majorAxisTo;

    public MajorAxisIntervalSpecification(double majorAxisFrom, double majorAxisTo) {
        this.majorAxisFrom = majorAxisFrom;
        this.majorAxisTo = majorAxisTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        Point2d startPoint = ellipse.getStartPoint();
        Point2d endPoint = ellipse.getEndPoint();
        double majorAxis = Math.abs(startPoint.getX() - endPoint.getX());

        return majorAxis >= majorAxisFrom && majorAxis <= majorAxisTo;
    }
}
