package edu.epam.figure.service;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;

public class EllipseService {

    public static EllipseService instance;

    private EllipseService() {

    }

    public static EllipseService getInstance() {
        if (instance == null) {
            instance = new EllipseService();
        }
        return instance;
    }

    public double calcSquareOfEllipse(Ellipse ellipse) {
        Point2d startPoint = ellipse.getStartPoint();
        Point2d endPoint = ellipse.getEndPoint();
        double majorAxis = Math.abs(startPoint.getX() - endPoint.getX());
        double minorAxis = Math.abs(startPoint.getY() - endPoint.getY());

        return (Math.PI * majorAxis * minorAxis) / 4;
    }

    public double calcPerimeterOfEllipse(Ellipse ellipse) {
        Point2d startPoint = ellipse.getStartPoint();
        Point2d endPoint = ellipse.getEndPoint();
        double majorAxis = Math.abs(startPoint.getX() - endPoint.getX());
        double minorAxis = Math.abs(startPoint.getY() - endPoint.getY());
        int power = 2;

        return ((Math.PI * minorAxis * majorAxis) + (Math.pow(minorAxis - majorAxis, power))) * 4;
    }

    public boolean isCircle(Ellipse ellipse) {
        Point2d startPoint = ellipse.getStartPoint();
        Point2d endPoint = ellipse.getEndPoint();
        double majorAxis = Math.abs(startPoint.getX() - endPoint.getX());
        double minorAxis = Math.abs(startPoint.getY() - endPoint.getY());

        return majorAxis == minorAxis;
    }

    public boolean isCrossOx(Ellipse ellipse) {
        Point2d startPoint = ellipse.getStartPoint();
        Point2d endPoint = ellipse.getEndPoint();

        return Double.compare(startPoint.getY(), 0.0) >= 0
                && Double.compare(endPoint.getY(), 0.0) <= 0;
    }

    public boolean isCrossOy(Ellipse ellipse) {
        Point2d startPoint = ellipse.getStartPoint();
        Point2d endPoint = ellipse.getEndPoint();

        return Double.compare(startPoint.getX(), 0.0) <= 0
                && Double.compare(endPoint.getX(), 0.0) >= 0;
    }
}
