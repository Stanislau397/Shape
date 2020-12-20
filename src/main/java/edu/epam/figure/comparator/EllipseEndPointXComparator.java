package edu.epam.figure.comparator;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;

import java.util.Comparator;

public class EllipseEndPointXComparator implements Comparator<Ellipse> {

    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        Point2d endPointFirstEllipse = o1.getEndPoint();
        Point2d endPointSecondEllipse = o2.getEndPoint();

        if (endPointFirstEllipse.getX() > endPointSecondEllipse.getX()) {
            return -1;
        } else if (endPointFirstEllipse.getX() < endPointSecondEllipse.getX()) {
            return 1;
        }
        return 0;
    }
}
