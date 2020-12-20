package edu.epam.figure.specification.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.EllipseData;
import edu.epam.figure.entity.EllipseWareHouse;
import edu.epam.figure.specification.EllipseSpecification;

public class SquareIntervalSpecification implements EllipseSpecification<Ellipse> {

    private double squareFrom;
    private double squareTo;

    public SquareIntervalSpecification(double squareFrom, double squareTo) {
        this.squareFrom = squareFrom;
        this.squareTo = squareTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseWareHouse wareHouse = EllipseWareHouse.getInstance();
        EllipseData data = wareHouse.get(ellipse.getEllipseId());

        double ellipseSquare = data.getSquare();

        return ellipseSquare >= squareFrom && ellipseSquare <= squareTo;
    }
}
