package com.furkanbostan.recyclerviewkullanm;

public class Car {
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
}
