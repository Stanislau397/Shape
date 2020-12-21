package edu.epam.shape.repository;

import edu.epam.shape.specification.EllipseSpecification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    void add(T t);

    void delete(T t);

    T get(int index);

    List<T> sort(Comparator<? super T> comparator);

    List<T> query(EllipseSpecification<T> specification);


}
