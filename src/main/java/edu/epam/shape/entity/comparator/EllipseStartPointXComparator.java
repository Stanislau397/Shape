package edu.epam.shape.entity.comparator;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.Point2d;

import java.util.Comparator;

public class EllipseStartPointXComparator implements Comparator<Ellipse> {

    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        Point2d startPointFirstObject = o1.getStartPoint();
        Point2d startPointSecondObject = o2.getStartPoint();

        if (startPointFirstObject.getX() > startPointSecondObject.getX()) {
            return 1;
        } else if (startPointFirstObject.getX() < startPointSecondObject.getX()) {
            return -1;
        }
        return 0;
    }
}
