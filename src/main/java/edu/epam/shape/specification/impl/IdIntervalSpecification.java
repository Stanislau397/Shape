package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.specification.EllipseSpecification;

public class IdIntervalSpecification implements EllipseSpecification<Ellipse> {

    private double idFrom;
    private double idTo;

    public IdIntervalSpecification(double idFrom, double idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double ellipseId = ellipse.getEllipseId();

        return ellipseId >= idFrom && ellipseId <= idTo;
    }
}
