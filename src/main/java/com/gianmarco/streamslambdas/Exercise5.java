// Use the Streams API to sort a stream of cars in reverse order by model
//  1. Do so by sorting by brand, then model, then year - all in one

package com.gianmarco.streamslambdas;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Exercise5 {

    public static void main(String[] args) {
        List<Exercise2.Car> cars = new ArrayList<>();

        cars.add(new Exercise2.Car("VW", "Polo", Year.of(2019)));
        cars.add(new Exercise2.Car("Ford", "Fiesta", Year.of(2023)));
        cars.add(new Exercise2.Car("Tesla", "Y", Year.of(2017)));
        cars.add(new Exercise2.Car("Toyota", "Yaris", Year.of(2022)));

        // 5.0
//        cars
//                .stream()
//                .sorted(Comparator.comparing(Exercise2.Car::model).reversed())
//                .forEach(System.out::println);

        // 5.1
        cars
                .stream()
                .sorted(
                        comparing(Exercise2.Car::brand)
                                .thenComparing(Exercise2.Car::model)
                                .thenComparing(Exercise2.Car::year)
                )
                .forEach(System.out::println);
    }
}
