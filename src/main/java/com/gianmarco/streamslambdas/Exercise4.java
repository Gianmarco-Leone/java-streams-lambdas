// Add an additional integer price field to your Car class/record. Use Streams to add total cost
// of all cars in your collection/stream. (Two ways to do this)
//  1. Use Streams to find average price of all cars (two ways to do this too)
//  2. How could you do exercise 4 with Streams & BigDecimal (for decimal accuracy)?
//  3. How could you do exercise 4.2 but output a formatted money String still using only the
//  Streams API?

package com.gianmarco.streamslambdas;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.reducing;

public class Exercise4 {
//    record Car(String brand, String model, Year year, int price){}


    // 4.2

    record Car(String make, String model, Year year, BigDecimal price){}

    public static void main(String[] args) {
//        List<Car> cars = new ArrayList<>();
//
//        cars.add(new Car("VW", "Polo", Year.of(2019), 22000));
//        cars.add(new Car("Ford", "Fiesta", Year.of(2023), 21500));
//        cars.add(new Car("Tesla", "Y", Year.of(2017), 60000));
//        cars.add(new Car("Toyota", "Yaris", Year.of(2022), 24000));
//
//        OptionalDouble average = cars.stream()
//                .mapToInt(Car::price)
////                .sum();
//                .average();// 4.1
//
////        System.out.printf("Il costo di tutte le auto è %,d,00 €", sum);
////        System.out.println(average); // 4.1


        // 4.2

//        BigDecimal sum = // 4.2
        String sum = // 4.3
                Stream.of(
                                new Car("VW", "Polo", Year.of(2019), new BigDecimal("22000.99")),
                                new Car("Ford", "Fiesta", Year.of(2023), new BigDecimal("21500.99")),
                                new Car("Tesla", "Y", Year.of(2017), new BigDecimal("60000.99")),
                                new Car("Toyota", "Yaris", Year.of(2022), new BigDecimal("24000.99")))
                        .map(Car::price)
//                        .reduce(BigDecimal.ZERO, BigDecimal::add); // 4.2
                        .collect(collectingAndThen(reducing(BigDecimal.ZERO, BigDecimal::add), NumberFormat.getCurrencyInstance()::format)); // 4.3
        System.out.println(sum);
    }

}
