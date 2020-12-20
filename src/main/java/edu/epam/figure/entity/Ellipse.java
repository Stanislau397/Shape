package edu.epam.figure.entity;

import edu.epam.figure.observer.Observable;
import edu.epam.figure.observer.Observer;
import edu.epam.figure.observer.impl.EllipseObserver;
import edu.epam.figure.util.IdGenerator;

public class Ellipse implements Observable<EllipseObserver> {

    private long ellipseId;
    private Point2d startPoint;
    private Point2d endPoint;
    private Observer<Ellipse> observer;

    public Ellipse(Point2d startPoint, Point2d endPoint) {
        ellipseId = IdGenerator.generateId();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public long getEllipseId() {
        return ellipseId;
    }

    public void setEllipseId(long ellipseId) {
        this.ellipseId = ellipseId;
        notifyObserver();
    }

    public Point2d getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point2d startPoint) {
        this.startPoint = startPoint;
        notifyObserver();
    }

    public Point2d getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point2d endPoint) {
        this.endPoint = endPoint;
        notifyObserver();
    }

    @Override
    public void attach(EllipseObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(EllipseObserver observer) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            observer.performPerimeter(this);
            observer.performSquare(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;

        Ellipse ellipse = (Ellipse) o;

        if (ellipseId != ellipse.ellipseId) return false;
        if (startPoint != null ? !startPoint.equals(ellipse.startPoint) : ellipse.startPoint != null) return false;
        return endPoint != null ? endPoint.equals(ellipse.endPoint) : ellipse.endPoint == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (ellipseId ^ (ellipseId >>> 32));
        result = 31 * result + (startPoint != null ? startPoint.hashCode() : 0);
        result = 31 * result + (endPoint != null ? endPoint.hashCode() : 0);
        result = 31 * result + (observer != null ? observer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" beginPoint = ").append(startPoint)
                .append(" endPoint: ").append(endPoint);
        return sb.toString();
    }
}