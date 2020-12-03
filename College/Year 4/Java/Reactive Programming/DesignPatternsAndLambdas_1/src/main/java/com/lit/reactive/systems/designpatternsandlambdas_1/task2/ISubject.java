package com.lit.reactive.systems.designpatternsandlambdas_1.task2;

import java.util.ArrayList;
import java.util.List;


public class ISubject {
    private List<IObserver> observers = new ArrayList<>();

    public void registerObserver(IObserver o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void notifyObservers(String msg) {
        observers.forEach(it->it.update(msg));
    }

    public static void main(String[] args) {
        IObserver obs1 = new WeatherObserver("Met Eireann");
        IObserver obs2 = new WeatherObserver("Jon Snow");
        IObserver obs3 = new TemperatureObserver("Temp Observer");

        ISubject weatherStation = new ISubject();

        weatherStation.registerObserver(obs1);
        weatherStation.registerObserver(obs2);

        weatherStation.notifyObservers("TEMPERATURE is 15C");
        weatherStation.notifyObservers("HUMIDITY is 99%");

        weatherStation.registerObserver(obs3);

        weatherStation.notifyObservers("TEMPERATURE is 13C");
        weatherStation.notifyObservers("Atmospheric Pressure is 999hpa");

    }

}
