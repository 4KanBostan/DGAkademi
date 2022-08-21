package com.furkanbostan.e_ticaret_mini.Models;

import androidx.versionedparcelable.ParcelField;

import kotlinx.parcelize.Parcelize;

@Parcelize
public class Product {
    String name;
    String cost;
    int imageURL;
    int counter;

    public Product(String name, String cost, int imageURL, int counter) {
        this.name = name;
        this.cost = cost;
        this.imageURL = imageURL;
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }

    public int  getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
