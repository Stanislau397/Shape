package edu.epam.figure.factory;

import edu.epam.figure.entity.Figure;

import java.util.List;

public interface FigureFactory {

    List<Figure> createFigure(List<String> lines);
}
