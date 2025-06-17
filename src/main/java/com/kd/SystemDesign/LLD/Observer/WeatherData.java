package com.kd.SystemDesign.LLD.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData extends Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void serWeatherData(Float temperature, Float humidity, Float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    public String toString() {
        return "temperature:" + temperature + " humidity:" + humidity + " pressure:" + pressure;
    }
}
