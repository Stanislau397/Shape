package edu.epam.figure;

import edu.epam.figure.entity.Figure;
import edu.epam.figure.factory.EllipseFactory;
import edu.epam.figure.reader.DataReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        EllipseFactory ellipseFactory = new EllipseFactory();
        List<Figure> ellipseList = ellipseFactory.createFigure(dataReader.readDataFromFile("file"));
        System.out.println(ellipseList);
    }

}
