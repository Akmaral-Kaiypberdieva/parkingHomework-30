package models;

import java.util.Random;

public class Car {
    private String number;
    private Magazine magazine;
    private State state;

    public Car(String number) {
        this.number = number;
        state = State.ON_WAY;
    }

    public void changeState(Parking park, int minute, int day){
        if(new Random().nextInt(100) + 1 <= 3){
            switch (state){
                case ON_WAY:
                    if(park.getCar().size() < 20){
                        System.out.println("Car is parking");
                        state = State.PARKING;
                        magazine = new Magazine(this, minute, day);
                        park.getCar().add(this);
                    } else {
                        System.out.println("Parking is full");
                    }
                    break;
                case PARKING:
                    System.out.println("The car leaves the park");
                    state = State.ON_WAY;
                    magazine.setMinuteCheckOut(minute);
                    magazine.setDay(day);
                    park.getMagazineList().add(magazine);
                    park.getCar().remove(this);
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'';
    }
}