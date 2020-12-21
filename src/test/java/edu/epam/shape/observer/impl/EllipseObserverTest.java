package edu.epam.shape.observer.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.EllipseData;
import edu.epam.shape.entity.EllipseWareHouse;
import edu.epam.shape.entity.Point2d;
import edu.epam.shape.repository.impl.EllipseRepository;
import edu.epam.shape.service.EllipseService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseObserverTest {

    EllipseRepository repository;
    EllipseWareHouse wareHouse;
    EllipseService service;
    EllipseObserver observer;

    @BeforeTest
    public void setUp() {
        this.repository = EllipseRepository.getInstance();
        this.wareHouse = EllipseWareHouse.getInstance();
        this.service = EllipseService.getInstance();
        this.observer = new EllipseObserver();
    }

    @BeforeClass
    public void beforeClass() {
        Ellipse ellipse = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        double square = service.calcSquareOfEllipse(ellipse);
        double perimeter = service.calcPerimeterOfEllipse(ellipse);
        long ellipseId = ellipse.getEllipseId();
        EllipseData data = new EllipseData(square, perimeter);
        repository.add(ellipse);
        wareHouse.put(ellipseId, data);
    }

    @Test
    public void notifyObserverTest() {
        Ellipse ellipse = repository.get(0);
        ellipse.attach(observer);
        ellipse.setStartPoint(new Point2d(4.0, 6.0));
        double square = service.calcSquareOfEllipse(ellipse);
        double perimeter = service.calcPerimeterOfEllipse(ellipse);
        long ellipseId = ellipse.getEllipseId();
        EllipseData data = wareHouse.get(ellipseId);
        boolean condition = ((square == data.getSquare()) && (perimeter == data.getPerimeter()));

        assertTrue(condition);
    }

    @AfterTest
    public void tierDown() {
        this.repository = null;
        this.wareHouse = null;
        this.service = null;
    }
}