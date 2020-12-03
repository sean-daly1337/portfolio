package com.lit.reactive.systems.designpatternsandlambdas_1.task2;

public class TemperatureObserver implements IObserver {
    private String name;

    public TemperatureObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String val) {
        System.out.println(name+" processed update :"+val);
    }
}
