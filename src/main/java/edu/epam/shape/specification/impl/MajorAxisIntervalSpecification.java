package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.Point2d;
import edu.epam.shape.specification.EllipseSpecification;

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
