package com.hcl.ingbootcamp.javadesignpattern.observer;

public class CurrentConditionLCDDisplay implements WeatherObserver, DisplayElement {

    private float temparature;
    private float humidity;
    private float pressure;

    public CurrentConditionLCDDisplay() {

    }

    public CurrentConditionLCDDisplay(WeatherOvservable obOvservable) {
        obOvservable.addObserver(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hcl.ingbootcamp.javadesignpattern.observer.DisplayElement#display()
     */
    @Override
    public void display() {
        System.out.printf("displaying latest temparature : temparature %.2f , humidity %.2f , pressure %.2f \n",
                this.temparature, this.humidity, this.pressure);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.hcl.ingbootcamp.javadesignpattern.observer.WeatherObserver#update(float,
     * float, float)
     */
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temparature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

}
