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


    public Car(int carID, String carModel, int carAge, String carRegistration, int carTopSpeed, List<String> carImages) {
        this.carID = carID;
        this.carModel = carModel;
        this.carAge = carAge;
        this.carRegistration = carRegistration;
        this.carTopSpeed = carTopSpeed;
        this.carImages = carImages;
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
}