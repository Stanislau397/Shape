package edu.epam.figure.factory;

import edu.epam.figure.entity.impl.Ellipse;
import edu.epam.figure.entity.Figure;
import edu.epam.figure.entity.Point2d;
import edu.epam.figure.parser.DoubleArrayParser;
import edu.epam.figure.validation.EllipseValidator;

import java.util.ArrayList;
import java.util.List;

public class EllipseFactory implements FigureFactory {

    @Override
    public List<Figure> createFigure(List<String> lines) {
        List<Figure> ellipseList = new ArrayList<>();
        EllipseValidator ellipseValidator = new EllipseValidator();
        DoubleArrayParser parser = new DoubleArrayParser();

        for (String line : lines) {

            List<Double> coordinates = parser.parseToDoubleArray(line);

            if (ellipseValidator.isValidEllipse(coordinates)) {

                ellipseList.add(new Ellipse(new Point2d(coordinates.get(0), coordinates.get(1)),
                        new Point2d(coordinates.get(2), coordinates.get(3))));
            }
        }
       return ellipseList;
    }
}
