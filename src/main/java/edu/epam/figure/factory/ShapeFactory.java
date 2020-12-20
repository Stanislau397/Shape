package edu.epam.figure.factory;

import java.util.List;

public interface ShapeFactory<T1, T2> {

    public T1 createShape(List<T2> points);
}
