package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.EllipseData;
import edu.epam.shape.entity.EllipseWareHouse;
import edu.epam.shape.specification.EllipseSpecification;

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
