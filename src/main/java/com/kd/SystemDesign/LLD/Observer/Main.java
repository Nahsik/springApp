package com.kd.SystemDesign.LLD.Observer;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Observer observer1 = new CurrentConditionsDisplay(weatherData);
        Observer observer2 = new CurrentConditionsDisplay(weatherData);

        weatherData.serWeatherData(1.2f, 2.3f, 3.2f);
    }
}
