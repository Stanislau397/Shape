package edu.epam.figure.observer.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.EllipseData;
import edu.epam.figure.entity.WareHouse;
import edu.epam.figure.observer.Observer;
import edu.epam.figure.service.EllipseService;

public class EllipseObserver implements Observer<Ellipse> {

    @Override
    public void performPerimeter(Ellipse ellipse) {
        EllipseService ellipseService = EllipseService.getInstance();
        WareHouse wareHouse = WareHouse.getInstance();
        EllipseData data = new EllipseData();

        long ellipseId = ellipse.getEllipseId();
        double perimeter = ellipseService.calcPerimeterOfEllipse(ellipse);
        data.setPerimeter(perimeter);

        wareHouse.putToWareHouse(ellipseId, data);
    }

    @Override
    public void performSquare(Ellipse ellipse) {
        EllipseService ellipseService = EllipseService.getInstance();
        WareHouse wareHouse = WareHouse.getInstance();
        EllipseData data = new EllipseData();

        long ellipseId = ellipse.getEllipseId();
        double square = ellipseService.calcSquareOfEllipse(ellipse);
        data.setSquare(square);

        wareHouse.putToWareHouse(ellipseId, data);
    }
}
