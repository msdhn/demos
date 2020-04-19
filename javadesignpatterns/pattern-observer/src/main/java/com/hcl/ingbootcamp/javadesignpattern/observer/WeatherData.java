package com.hcl.ingbootcamp.javadesignpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author masud
 */
public class WeatherData implements WeatherOvservable {

    private List<WeatherObserver> observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    public void setMeasurement(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementIsChanged();
    }

    public void measurementIsChanged() {
        notifyObservers();
    }

    @Override
    public void addObserver(WeatherObserver o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(WeatherObserver o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver eachOne : this.observers) {
            eachOne.update(this.temp, this.humidity, this.pressure);
        }
    }

}
