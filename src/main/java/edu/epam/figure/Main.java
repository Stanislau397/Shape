package edu.epam.figure;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.WareHouse;
import edu.epam.figure.factory.EllipseFactory;
import edu.epam.figure.observer.Observer;
import edu.epam.figure.observer.impl.EllipseObserver;
import edu.epam.figure.repository.EllipseRepository;
import edu.epam.figure.repository.impl.EllipseRepositoryImpl;
import edu.epam.figure.service.EllipseService;
import edu.epam.figure.util.DataReader;

import java.util.List;

public class Main {

    public static void main(String[] arg ) {
        DataReader dataReader = new DataReader();
        EllipseFactory ellipseFactory = new EllipseFactory();
        EllipseService ellipseService = EllipseService.getInstance();
        List<Ellipse> ellipses = ellipseFactory.createEllipse(dataReader.readDataFromFile("file"));
        System.out.println(ellipseService.calcPerimeterOfEllipse(ellipses.get(0)));
        System.out.println(ellipseService.calcSquareOfEllipse(ellipses.get(0)));
        System.out.println(ellipseService.isCircle(ellipses.get(0)));
        System.out.println(ellipseService.isCrossOx(ellipses.get(0)));
        System.out.println(ellipseService.isCrossOy(ellipses.get(0)));
    }
}
