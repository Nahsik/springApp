package com.kd.SystemDesign.LLD.Observer;

public class CurrentConditionsDisplay implements  Observer{

    WeatherData weatherData;


    public CurrentConditionsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("CurrentConditionsDisplay temp" + weatherData );
    }
}
