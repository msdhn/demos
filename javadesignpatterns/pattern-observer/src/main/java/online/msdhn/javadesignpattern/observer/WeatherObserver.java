package online.msdhn.javadesignpattern.observer;

/**
 * @author masud
 */
public interface WeatherObserver {

    public void update(float temp, float humidity, float pressure);

}
