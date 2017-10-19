package com.example.cobeosijek.carsapp.car_showroom.utils;

import com.example.cobeosijek.carsapp.car_showroom.Car;

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

        images = new ArrayList<>();
        images.add("https://www.4wheelsnews.com/images/photo_galleries/original/26380/2017-skoda-octavia-facelift-7.jpg");
        images.add("http://images.car.bauercdn.com/pagefiles/69828/skoda_octavia_review_09.jpg");
        images.add("https://i.wheelsage.org/pictures/s/skoda/octavia_rs_combi/skoda_octavia_rs_combi_68.jpeg");
        cars.add(new Car(5, "Skoda Octavia Combi", 2016, "OS 576 LS", 210, images, true));

        return cars;
    }
}
