// Add more different makes of cars to your collection of cars and then
// Tesla S 2014 $90,000.99
// Tesla X 2015 $110,000.99
// Tesla 3 2016 $55,000.99
// Tesla Y 2017 $60,000.99
// Tesla Roadster 2009 $135,000.99
// Lucid Air 2021 $77,399.99
// Hyundai Ioniq 2021 $34,250.00
// Hyundai Kona 2021 $38,575.00
// Porsche Taycan 2021 $81,250.00
// Audi e-tron 2021 $66,995.00
// Volkswagen ID.4 2021 $41,190.00
//   1. Determine total price by make
//   2. Determine average car price by make
//     1. This one will be fun/challenging. You’ll want to take a look at the Collectors.teeing()
//     function, which I did not explicitly teach but have a look at its javadoc. If this proves
//     to be too hard but you want to still try it without looking @ my solution, it will be
//     MUCH easier if you convert the prices to any other numeric type before using
//     Streams API (but not as much fun…)
//     2. Did you get 7.2.1? Let’s make it even more fun. Format the average prices for
//     currency, within the Streams API.
//   3. Determine number of cars by year and then by make
//   4. Determine number of cars by make by first creating a new, empty Map, then iterating
//   over the collection of cars (you’ve been using for previous exercises) and using a
//   functional method of the Map interface to populate your empty Map.

package com.gianmarco.streamslambdas;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Exercise7 {
    record Car(String make, String model, Year year, BigDecimal price){}

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Tesla", "S", Year.of(2014), new BigDecimal("90000.99")),
                new Car("Tesla", "X", Year.of(2015), new BigDecimal("110000.99")),
                new Car("Tesla", "3", Year.of(2016), new BigDecimal("55000.99")),
                new Car("Tesla", "Y", Year.of(2017), new BigDecimal("60000.99")),
                new Car("Tesla", "Roadster", Year.of(2009), new BigDecimal("135000.99")),
                new Car("Lucid", "Air", Year.of(2021), new BigDecimal("77399.99")),
                new Car("Hyundai", "Ioniq", Year.of(2021), new BigDecimal("34250.00")),
                new Car("Hyundai", "Kona", Year.of(2021), new BigDecimal("38575.00")),
                new Car("Porsche", "Taycan", Year.of(2021), new BigDecimal("81250.00")),
                new Car("Audi", "e-tron", Year.of(2021), new BigDecimal("66995.00")),
                new Car("Volkswagen", "ID.4", Year.of(2021), new BigDecimal("41190"))
        );


        // 7.1
//        Map<String, BigDecimal> sumByMake = cars.stream()
//                .collect(groupingBy(
//                        Car::make,
//                        reducing(BigDecimal.ZERO, Car::price, BigDecimal::add)));
//        System.out.println(sumByMake);

        // 7.2.1
//        Map<String, BigDecimal> averageByMake = cars.stream()
//                .collect(groupingBy(
//                        Car::make,
//                        teeing(
//                                reducing(BigDecimal.ZERO, Car::price, BigDecimal::add),
//                                counting(),
//                                (sum, count) -> sum.divide(new BigDecimal(count))
//                        )
//                ));
//        System.out.println(averageByMake);

        // 7.2.2
//        Map<String, String> formattedAverageByMake = cars.stream()
//                .collect(groupingBy(
//                        Car::make,
//                        collectingAndThen(teeing(
//                                reducing(BigDecimal.ZERO, Car::price, BigDecimal::add),
//                                counting(),
//                                (sum, count) -> sum.divide(new BigDecimal(count))
//                        ), NumberFormat.getCurrencyInstance()::format)
//                ));
//        System.out.println(formattedAverageByMake);

        // 7.3
//        Map<Year, Map<String, Long>> carsNumberByYearAndMake = cars.stream()
//                .collect(groupingBy(
//                        Car::year,
//                        groupingBy(Car::make, counting())
//                ));
//
//        System.out.println(carsNumberByYearAndMake);

        // 7.4
        Map<String, Integer> countsByMake = new HashMap<>();
        cars.stream()
                .forEach(car -> countsByMake.merge(car.make, 1, Integer::sum));
        System.out.println(countsByMake);
    }
}
