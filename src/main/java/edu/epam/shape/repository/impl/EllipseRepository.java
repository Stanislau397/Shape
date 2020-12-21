package edu.epam.shape.repository.impl;

import edu.epam.shape.entity.Ellipse;
import edu.epam.shape.repository.Repository;
import edu.epam.shape.specification.EllipseSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseRepository implements Repository<Ellipse> {

    private static EllipseRepository instance;
    private List<Ellipse> ellipses;

    private EllipseRepository() {
        this.ellipses = new ArrayList<>();
    }

    public static EllipseRepository getInstance() {
        if (instance == null) {
            instance = new EllipseRepository();
        }
        return instance;
    }

    @Override
    public void add(Ellipse ellipse) {
        ellipses.add(ellipse);
    }

    @Override
    public void delete(Ellipse ellipse) {
        ellipses.remove(ellipse);
    }

    @Override
    public Ellipse get(int index) {
        return ellipses.get(index);
    }

    @Override
    public List<Ellipse> sort(Comparator<? super Ellipse> comparator) {
        List<Ellipse> sortedEllipses = ellipses;
        sortedEllipses.sort(comparator);
        return sortedEllipses;
    }

    @Override
    public List<Ellipse> query(EllipseSpecification<Ellipse> specification) {
        List<Ellipse> resultList = ellipses.stream()
                .filter(o -> specification.specify(o))
                .collect(Collectors.toList());;

        return resultList;
    }
}
