package edu.epam.figure.repository.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.repository.EllipseSpecification;

public class IdSpecificationInterval implements EllipseSpecification<Ellipse> {

    private double idFrom;
    private double idTo;

    public IdSpecificationInterval(double idFrom, double idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double ellipseId = ellipse.getEllipseId();

        return ellipseId >= idFrom && ellipseId <= idTo;
    }
}
