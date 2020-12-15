package edu.epam.figure.repository;

public interface Specification<T> {

    boolean specify(T t);
}
