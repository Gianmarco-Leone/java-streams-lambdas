// How could you use the Streams API to filter out (not show) all cars made before a certain
// year? (If you modeled Car year using the Year date/time class, it has a method isAfter())

package com.gianmarco.streamslambdas;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    record Car(String brand, String model, Year year){}

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("VW", "Polo", Year.of(2019)));
        cars.add(new Car("Ford", "Fiesta", Year.of(2023)));
        cars.add(new Car("Tesla", "Y", Year.of(2017)));
        cars.add(new Car("Toyota", "Yaris", Year.of(2022)));

        cars
                .stream()
                .filter(c -> c.year.isAfter(Year.of(2019)))
                .forEach(System.out::println);
    }
}
