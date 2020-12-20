package edu.epam.shape.observer;

public interface Observable<E> {

    void attach(E observer);

    void detach(E observer);

    void notifyObserver();
}
