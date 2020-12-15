package edu.epam.figure.factory;

import edu.epam.figure.constant.IndexConstant;
import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.entity.Point2d;
import edu.epam.figure.parser.DoubleArrayParser;
import edu.epam.figure.validator.EllipseValidator;

import java.util.ArrayList;
import java.util.List;

public class EllipseFactory {

    public List<Ellipse> createEllipse(List<String> lines) {
        List<Ellipse> ellipseList = new ArrayList<>();
        List<Double> coordinates;
        EllipseValidator ellipseValidator = new EllipseValidator();
        DoubleArrayParser parser = new DoubleArrayParser();

        for (String line : lines) {

            coordinates = parser.parseToDoubleArray(line);

            if (ellipseValidator.isValidEllipse(coordinates)) {

                ellipseList.add(new Ellipse(
                                new Point2d(coordinates.get(IndexConstant.INDEX_X1), coordinates.get(IndexConstant.INDEX_Y1)),
                                new Point2d(coordinates.get(IndexConstant.INDEX_X2), coordinates.get(IndexConstant.INDEX_Y2))));
            }
        }
       return ellipseList;
    }
}
