package com.kd.SystemDesign.LLD.Observer;

public abstract class Subject {
    abstract void registerObserver(Observer observer);

    abstract void removeObserver(Observer observer);

    abstract void notifyObservers();
}
