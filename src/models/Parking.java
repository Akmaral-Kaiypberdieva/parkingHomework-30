package models;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List <Car> car;
    private List<Magazine> magazineList;

    public Parking() {
        car = new ArrayList<>();
        magazineList = new ArrayList<>();
    }

    public  List<Magazine> makeCheckForPay(){
        List<Magazine> payCheck = new ArrayList<>();
        try {
            for(int i = 0; i <= magazineList.size(); i++){
                int sum = 0;
                int timeOnPark = 0;
                Magazine magazine = magazineList.get(0);
                if(magazine.getMinuteCheckOut() - magazine.getMinuteCheckIn() >= 30 || magazine.getMinuteCheckIn() > 720 && magazine.getMinuteCheckOut() >= 30){
                    if(magazine.getMinuteCheckOut() > 720 && magazine.getMinuteCheckIn() < 720){
                        timeOnPark = 720 - magazine.getMinuteCheckIn();
                    } else if (magazine.getMinuteCheckOut() < 720 && magazine.getMinuteCheckIn() < 720) {
                        timeOnPark = magazine.getMinuteCheckOut() - magazine.getMinuteCheckIn();
                    } else if (magazine.getMinuteCheckOut() < 720 && magazine.getMinuteCheckIn() > 720) {
                        timeOnPark = magazine.getMinuteCheckOut();
                    }
                }
                if(timeOnPark != 0){
                    sum = timeOnPark / 5 * 10;
                    payCheck.add(new Magazine(magazine.getCar(), sum, magazine.getDay()));
                }else if(magazine.getMinuteCheckOut() == 1440 && magazine.getMinuteCheckIn() == 1440){
                    if(timeOnPark > 30){
                        sum = timeOnPark / 1 * 2;
                        payCheck.add(new Magazine(magazine.getCar(), sum,  magazine.getDay()));
                    }
                }
            }
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return payCheck;
    }

    public List<Car> getCar() {
        return car;
    }

    public List<Magazine> getMagazineList() {
        return magazineList;
    }


    @Override
    public String toString() {
        return "Parking{" +
                "car=" + car +
                ", magazineList=" + magazineList;
    }
}
