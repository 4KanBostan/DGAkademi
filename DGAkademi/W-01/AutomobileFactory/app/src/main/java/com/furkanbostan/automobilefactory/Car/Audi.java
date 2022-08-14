package com.furkanbostan.automobilefactory.Car;

public class Audi extends Car{
    public Audi(String model, String marka, int logo) {
        super(model, marka, logo);
    }

    @Override
    public int NumbOfDoor() {
        return 5;
    }

    @Override
    public int NumbOfEngine() {
        return 1;
    }

    @Override
    public int NumbOfWheel() {
        return 4;
    }
}
