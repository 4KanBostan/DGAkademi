package com.furkanbostan.automobilefactory.Car;


public class BMW extends Car{

    public BMW(String model, String marka, int logo) {
        super(model, marka, logo);
    }

    @Override
    public int NumbOfDoor() {
        return 2;
    }

    @Override
    public int NumbOfEngine() {
        return 2;
    }

    @Override
    public int NumbOfWheel() {
        return 6;
    }
}

