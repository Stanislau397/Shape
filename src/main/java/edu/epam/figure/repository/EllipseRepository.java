package edu.epam.figure.repository;

import java.util.Comparator;
import java.util.List;

public interface EllipseRepository<T> {

    void add(T t);

    void delete(T t);

    T get(int index);

    List<T> sort(Comparator<? super T> comparator);

    List<T> query(Specification<T> specification);


}
