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
        cars.add(new Car(1, "Opel Astra", 2005, "PZ 408 DA", 180, images, true));
        cars.add(new Car(2, "Ford Fiesta", 2003, "PZ 525 DD", 130, images, true));
        cars.add(new Car(3, "Mazda 6", 2005, "PZ 626 CA", 176, images, false));
        cars.add(new Car(4, "Volkswagen Polo", 2005, "PZ 178 CA", 120, images, false));

        return cars;
    }
}
