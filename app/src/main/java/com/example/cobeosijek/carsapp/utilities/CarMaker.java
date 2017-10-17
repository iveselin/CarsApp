package com.example.cobeosijek.carsapp.utilities;

import com.example.cobeosijek.carsapp.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarMaker {
    private CarMaker() {
    }

    public static List<Car> createCars() {

        List<Car> cars = new ArrayList<>();

        List<String> images = new ArrayList<>();
        images.add("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Opel_Astra_%284559359674%29.jpg/280px-Opel_Astra_%284559359674%29.jpg");
        cars.add(new Car(2, "Opel Astra", 2005, "PZ 408 DA", 150, images));
        cars.add(new Car(2, "Opel Astra", 2005, "PZ 408 DA", 150, images));
        cars.add(new Car(2, "Opel Astra", 2005, "PZ 408 DA", 150, images));
        cars.add(new Car(2, "Opel Astra", 2005, "PZ 408 DA", 150, images));

        return cars;
    }
}
