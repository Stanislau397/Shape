package edu.epam.figure.repository.impl;

import edu.epam.figure.entity.Ellipse;
import edu.epam.figure.repository.EllipseRepository;
import edu.epam.figure.repository.EllipseSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseRepositoryImpl implements EllipseRepository<Ellipse> {

    private static EllipseRepositoryImpl instance;
    private List<Ellipse> ellipses;

    private EllipseRepositoryImpl() {
        this.ellipses = new ArrayList<>();
    }

    public static EllipseRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new EllipseRepositoryImpl();
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
        List<Ellipse> resultList = ellipses;

        return resultList.stream()
                .filter(o -> specification.specify(o))
                .collect(Collectors.toList());
    }
}
