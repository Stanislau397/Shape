package edu.epam.shape.observer;

import edu.epam.shape.entity.Ellipse;

public interface Observer<T extends Ellipse> {

    void performPerimeter(T t);

    void performSquare(T t);
}
