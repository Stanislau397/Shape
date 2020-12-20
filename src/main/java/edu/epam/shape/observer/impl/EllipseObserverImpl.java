package edu.epam.shape.observer.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.EllipseData;
import edu.epam.shape.entity.EllipseWareHouse;
import edu.epam.shape.observer.EllipseObserver;
import edu.epam.shape.service.EllipseService;

public class EllipseObserverImpl implements EllipseObserver<Ellipse> {

    @Override
    public void performPerimeter(Ellipse ellipse) {
        EllipseService ellipseService = EllipseService.getInstance();
        EllipseWareHouse wareHouse = EllipseWareHouse.getInstance();
        EllipseData data = new EllipseData();

        long ellipseId = ellipse.getEllipseId();
        double perimeter = ellipseService.calcPerimeterOfEllipse(ellipse);
        data.setPerimeter(perimeter);

        wareHouse.put(ellipseId, data);
    }

    @Override
    public void performSquare(Ellipse ellipse) {
        EllipseService ellipseService = EllipseService.getInstance();
        EllipseWareHouse wareHouse = EllipseWareHouse.getInstance();
        EllipseData data = new EllipseData();

        long ellipseId = ellipse.getEllipseId();
        double square = ellipseService.calcSquareOfEllipse(ellipse);
        data.setSquare(square);

        wareHouse.put(ellipseId, data);
    }
}
