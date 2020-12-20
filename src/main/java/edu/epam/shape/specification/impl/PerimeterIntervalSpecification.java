package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.EllipseData;
import edu.epam.shape.entity.EllipseWareHouse;
import edu.epam.shape.specification.EllipseSpecification;

public class PerimeterIntervalSpecification implements EllipseSpecification<Ellipse> {

    private double perimeterFrom;
    private double perimeterTo;

    public PerimeterIntervalSpecification(double perimeterFrom, double perimeterTo) {
        this.perimeterFrom = perimeterFrom;
        this.perimeterTo = perimeterTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseWareHouse wareHouse = EllipseWareHouse.getInstance();
        EllipseData data = wareHouse.get(ellipse.getEllipseId());

        double perimeter = data.getPerimeter();

        return perimeter >= perimeterFrom && perimeter <= perimeterTo;
    }
}
