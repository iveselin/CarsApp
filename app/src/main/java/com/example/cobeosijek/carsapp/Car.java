package com.example.cobeosijek.carsapp;

import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class Car {

    private int carID;
    private String carModel;
    private int carAge;
    private String carRegistration;
    private int carTopSpeed;
    private List<String> carImages;

    private boolean isFavourite;

    public Car(int carID, String carModel, int carAge, String carRegistration, int carTopSpeed, List<String> carImages, boolean isFavourite) {
        this.carID = carID;
        this.carModel = carModel;
        this.carAge = carAge;
        this.carRegistration = carRegistration;
        this.carTopSpeed = carTopSpeed;
        this.carImages = carImages;
        this.isFavourite = isFavourite;
    }


    public int getCarID() {
        return carID;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getCarAge() {
        return carAge;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public int getCarTopSpeed() {
        return carTopSpeed;
    }

    public List<String> getCarImages() {
        return carImages;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void toggleFavourite() {
        isFavourite = !isFavourite;
    }


}
