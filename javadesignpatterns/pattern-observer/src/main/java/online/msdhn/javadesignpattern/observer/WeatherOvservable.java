package online.msdhn.javadesignpattern.observer;

/**
 * @author masud
 */
public interface WeatherOvservable {

    public void addObserver(WeatherObserver o);

    public void removeObserver(WeatherObserver o);

    public void notifyObservers();
}
