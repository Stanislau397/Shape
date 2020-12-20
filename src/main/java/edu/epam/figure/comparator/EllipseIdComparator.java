package edu.epam.figure.comparator;

import edu.epam.figure.entity.Ellipse;

import java.util.Comparator;

public class EllipseIdComparator implements Comparator<Ellipse> {

    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        if (o1.getEllipseId() > o2.getEllipseId()) {
            return -1;
        } else if (o1.getEllipseId() < o2.getEllipseId()) {
            return 1;
        }
        return 0;
    }
}
