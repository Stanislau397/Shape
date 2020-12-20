package edu.epam.shape.repository.impl;

import edu.epam.shape.comparator.EllipseIdComparator;
import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.entity.Point2d;
import edu.epam.shape.specification.impl.IdSpecificationInterval;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class EllipseRepositoryImplTest {

    EllipseRepositoryImpl repository;

    @BeforeTest
    public void setUp() {
        this.repository = EllipseRepositoryImpl.getInstance();
    }

    @Test
    public void testSort() {
        EllipseIdComparator comparator = new EllipseIdComparator();
        Ellipse ellipse = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        Ellipse ellipse1 = new Ellipse(new Point2d(3.0, 4.0), new Point2d(4.0, 6.0));
        repository.add(ellipse);
        repository.add(ellipse1);

        List<Ellipse> result = repository.sort(comparator);
        List<Ellipse> expResult = new ArrayList<>();
        expResult.add(ellipse);
        expResult.add(ellipse1);

        assertEquals(result, expResult);
    }

    @Test
    public void testQuery() {
        IdSpecificationInterval specification = new IdSpecificationInterval(1, 3);
        Ellipse ellipse = new Ellipse(new Point2d(2.0, 3.0), new Point2d(4.0, 6.0));
        Ellipse ellipse1 = new Ellipse(new Point2d(3.0, 4.0), new Point2d(4.0, 6.0));
        repository.add(ellipse);
        repository.add(ellipse1);

        List<Ellipse> result = repository.query(specification);
        List<Ellipse> expResult = new ArrayList<>();
        expResult.add(ellipse);
        expResult.add(ellipse1);

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.repository = null;
    }
}