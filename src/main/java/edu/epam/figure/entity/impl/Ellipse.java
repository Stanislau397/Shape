package edu.epam.figure.entity.impl;

import edu.epam.figure.entity.Figure;
import edu.epam.figure.entity.Point2d;

public class Ellipse implements Figure {

    private long ellipseId;
    private Point2d beginPoint;
    private Point2d endPoint;

    public Ellipse(long ellipseId, Point2d beginPoint, Point2d endPoint) {
        this.ellipseId = ellipseId;
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Ellipse(Point2d beginPoint, Point2d endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Ellipse() {

    }

    public long getEllipseIdId() {
        return ellipseId;
    }

    public void setEllipseId(long ellipseId) {
        this.ellipseId = ellipseId;
    }

    public Point2d getBeginPoint() {
        return beginPoint;
    }

    public void setBeginPoint(Point2d beginPoint) {
        this.beginPoint = beginPoint;
    }

    public Point2d getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point2d endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;

        Ellipse ellipse = (Ellipse) o;

        if (ellipseId != ellipse.ellipseId) return false;
        if (beginPoint != null ? !beginPoint.equals(ellipse.beginPoint) : ellipse.beginPoint != null) return false;
        return endPoint != null ? endPoint.equals(ellipse.endPoint) : ellipse.endPoint == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (ellipseId ^ (ellipseId >>> 32));
        result = 31 * result + (beginPoint != null ? beginPoint.hashCode() : 0);
        result = 31 * result + (endPoint != null ? endPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" beginPoint = ").append(beginPoint)
                .append(" endPoint: ").append(endPoint);
        return sb.toString();
    }
}
