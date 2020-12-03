package com.lit.reactive.systems.designpatternsandlambdas_1.task2;

public class WeatherObserver implements IObserver {
    private String name;

    public WeatherObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String val) {
        System.out.println(name+" received update : "+val);
    }
}
