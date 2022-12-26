package models;

import java.util.ArrayList;
import java.util.List;

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
        park.makeCheckForPay();
    }
}