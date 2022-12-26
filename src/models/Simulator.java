package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class Simulator {
    public static void randomNumber(List<Car>cars) {
        for (int i = 0; i < 10; i ++){
            cars.add(new Car("A0#P" + i));
        }
    }
    public static void period(){
        List<Car> cars = new ArrayList<>();
        randomNumber(cars);
        Parking park = new Parking();
        int day = 1;
        while (day <= 30) {
            for (int i = 0; i <= 1440; i += 5) {
                int currentTime = i;
                int currentData = day;
                cars.forEach(c -> c.changeState(park, currentTime, currentData));
            }
            day++;
        }
         List<Magazine> magazines = park.makeCheckForPay();
        var checkForDay = magazines.stream()
                .collect(groupingBy(Magazine::getDay,summingDouble(Magazine::getSum)));
        var sumMin = magazines.stream()
                .min(Comparator.comparing(Magazine::getSum))
                .map(Magazine::getSum);
        var sum = magazines.stream()
                .map(Magazine::getSum);
        var count = magazines.stream()
                .filter(e->e.getMinuteCheckOut()<30)
                .count();
        var theLongest = magazines.stream()
                .sorted(Comparator.comparing(Magazine::getMinuteCheckOut).reversed());
        var theLongest2 = magazines.stream()
                .collect(Collectors.toList());
        var lind = magazines.stream()
                .limit(10);
        var list = magazines.stream()
                .filter(c -> c.getCar().equals(cars));

    }
}