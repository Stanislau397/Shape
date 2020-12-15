package edu.epam.figure.observer;

import edu.epam.figure.entity.Ellipse;

public interface Observer<T extends Ellipse> {

    void performPerimeter(T t);

    void performSquare(T t);
}
