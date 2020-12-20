package edu.epam.figure.parser;

import edu.epam.figure.entity.Point2d;
import edu.epam.figure.validator.ArgumentsValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PointParser {

    public static final Logger logger = LogManager.getLogger(PointParser.class);
    private static final int INDEX_X1 = 0;
    private static final int INDEX_Y1 = 1;
    private static final int INDEX_X2 = 2;
    private static final int INDEX_Y2 = 3;

    public List<Point2d> parseToPointList(List<String> lines) {
        Double2dListParser parser = new Double2dListParser();
        ArgumentsValidator validator = new ArgumentsValidator();
        List<Point2d> points = new ArrayList<>();
        List<List<Double>> coordinates;
        int index = -1;

        for (String line : lines) {

            coordinates = parser.parseToDouble2dList(line);
            index = index + 1;

            if (validator.isEnoughArguments(coordinates.get(0))) {
                points.add(new Point2d(coordinates.get(0).get(INDEX_X1), coordinates.get(0).get(INDEX_Y1)));
                points.add(new Point2d(coordinates.get(0).get(INDEX_X2), coordinates.get(0).get(INDEX_Y2)));
            } else {
                logger.log(Level.WARN, "Not enough arguments to parse line: {}", lines.get(index));
            }
        }
        return points;
    }
}
