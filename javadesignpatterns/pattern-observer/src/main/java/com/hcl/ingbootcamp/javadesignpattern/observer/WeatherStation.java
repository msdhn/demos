package com.hcl.ingbootcamp.javadesignpattern.observer;

public class WeatherStation {

    public static void main(String... args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionLCDDisplay display = new CurrentConditionLCDDisplay(weatherData);

        // CurrentConditionLEDDisplay display = new CurrentConditionLCDDisplay();

        weatherData.setMeasurement(26.6f, 45.1f, 30.2f);
        weatherData.setMeasurement(26.9f, 46.1f, 36.2f);
        weatherData.setMeasurement(26.5f, 46.1f, 38.2f);

    }

}
