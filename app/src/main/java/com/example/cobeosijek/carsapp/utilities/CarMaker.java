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

        images.clear();
        images.add("http://automobilio.info/auto/Opel-Astra-H.jpg");
        images.add("https://automobili.hr/wp/wp-content/uploads/2017/03/rabljeni-automobil-savjet-opel-astra-provjera-detaljan-pregled-010.jpg");
        images.add("https://upload.wikimedia.org/wikipedia/commons/1/13/Opel_Astra_H_rear_20091011.jpg");
        cars.add(new Car(1, "Opel Astra", 2005, "PZ 408 DA", 180, images, true));

        images = new ArrayList<>();
        images.add("https://www.driving.co.uk/s3/st-driving-prod/uploads/2014/07/fiesta-11.jpg");
        images.add("https://s1.cdn.autoevolution.com/images/gallery/FORDFiesta3Doors-2785_6.jpg");
        cars.add(new Car(2, "Ford Fiesta", 2003, "PZ 525 DD", 130, images, false));

        images = new ArrayList<>();
        images.add("https://upload.wikimedia.org/wikipedia/commons/f/f3/Mazda_6_%28GG%29_registered_September_2002_1999cc.JPG");
        cars.add(new Car(3, "Mazda 6", 2005, "PZ 626 CA", 176, images, true));

        images = new ArrayList<>();
        images.add("http://automobilio.info/auto/Volkswagen-Polo-IV-9N.jpg");
        cars.add(new Car(4, "Volkswagen Polo", 2005, "PZ 178 CA", 120, images, false));

        return cars;
    }
}
