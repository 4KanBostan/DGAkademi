package com.furkanbostan.automobilefactory.Car;

public abstract class Car {

    private String model;
    private String marka;
    private int logo;

    public Car(String model, String marka, int logo) {
        this.model = model;
        this.marka = marka;
        this.logo = logo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }


    abstract int NumbOfDoor();

    abstract int NumbOfEngine();

    abstract int NumbOfWheel();

    public String carInfo(){
        System.out.println("Araç içeriğinde"+NumbOfDoor()+" kapı, "+NumbOfEngine()+" motor, "+NumbOfWheel()+" teker bulunmaktadır.");
        return "Araç içeriğinde "+NumbOfDoor()+" kapı, "+NumbOfEngine()+" motor, "+NumbOfWheel()+" teker bulunmaktadır.";
    }
    }
