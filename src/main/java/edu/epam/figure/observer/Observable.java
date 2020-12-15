package edu.epam.figure.observer;

public interface Observable<E> {

    void attach(E observer);

    void detach(E observer);

    void notifyObserver();
}
