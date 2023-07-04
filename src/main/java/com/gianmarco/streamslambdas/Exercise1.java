// Using the same car collection approach as in the last section’s exercises, create a
// collection of cars but use the Streams API to print out only the cars’ model names.

package com.gianmarco.streamslambdas;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Exercise1 {
    record Car(String brand, String model, Year year){}

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("VW", "Polo", Year.of(2019)));
        cars.add(new Car("Ford", "Fiesta", Year.of(2023)));
        cars.add(new Car("Tesla", "Y", Year.of(2017)));
        cars.add(new Car("Toyota", "Yaris", Year.of(2022)));

        cars
                .stream()
                .map(Car::model)
                .forEach(System.out::println);
    }
}
