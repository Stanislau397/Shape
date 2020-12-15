package edu.epam.figure.observer.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.WareHouse;
import edu.epam.figure.observer.Observer;
import edu.epam.figure.service.EllipseService;

public class EllipseObserver implements Observer<Ellipse> {

    @Override
    public void performPerimeter(Ellipse ellipse) {
        EllipseService ellipseService = EllipseService.getInstance();
        long ellipseId = ellipse.getEllipseId();
        double perimeter = ellipseService.calcPerimeterOfEllipse(ellipse);

        WareHouse wareHouse = WareHouse.getInstance();
        wareHouse.putToWareHouse(ellipseId, perimeter);
    }

    @Override
    public void performSquare(Ellipse ellipse) {
        EllipseService ellipseService = EllipseService.getInstance();
        long ellipseId = ellipse.getEllipseId();
        double square = ellipseService.calcSquareOfEllipse(ellipse);

        WareHouse wareHouse = WareHouse.getInstance();
        wareHouse.putToWareHouse(ellipseId, square);
    }
}
