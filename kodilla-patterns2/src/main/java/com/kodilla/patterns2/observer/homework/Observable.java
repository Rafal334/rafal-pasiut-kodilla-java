package com.kodilla.patterns2.observer.homework;

public interface Observable {

    void registerObserver(Observer observer);

    void updateObserver();

    void removeObserver(Observer observer);
}
