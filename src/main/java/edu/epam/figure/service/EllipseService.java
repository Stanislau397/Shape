package edu.epam.figure.service;

import edu.epam.figure.entity.Point2d;
import edu.epam.figure.entity.impl.Ellipse;

public class EllipseService {

    public double calcAreaOfEllipse(Ellipse ellipse) {
        Point2d begin = ellipse.getBeginPoint();
        Point2d end = ellipse.getEndPoint();

        return Math.PI * ((end.getX() - begin.getX()) / 2 * (begin.getY() - end.getY()) / 2);
    }

    public double calcPerimeterOfEllipse(Ellipse ellipse) {
        Point2d begin = ellipse.getBeginPoint();
        Point2d end = ellipse.getEndPoint();

        return Math.PI * ((end.getX() - begin.getX()) / 2 + (begin.getY() - end.getY()) / 2);
    }

    public boolean isCircle(Ellipse ellipse) {
        Point2d begin = ellipse.getBeginPoint();
        Point2d end = ellipse.getEndPoint();

        return end.getX() - begin.getX() == begin.getY() - end.getY();
    }

    public boolean isCrossOx(Ellipse ellipse) {
        Point2d beginDot = ellipse.getBeginPoint();
        Point2d endDot = ellipse.getEndPoint();

        return Double.compare(beginDot.getY(), 0.0) >= 0
                && Double.compare(endDot.getY(), 0.0) <= 0;
    }

    public boolean isCrossOy(Ellipse ellipse) {
        Point2d beginDot = ellipse.getBeginPoint();
        Point2d endDot = ellipse.getEndPoint();

        return Double.compare(beginDot.getX(), 0.0) <= 0
                && Double.compare(endDot.getX(), 0.0) >= 0;
    }
}
