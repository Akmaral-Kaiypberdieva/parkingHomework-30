package models;

public class Magazine {
    private Car car;
    private int minuteCheckIn;
    private int minuteCheckOut;
    private int day;

    public Magazine(Car car, int minuteCheckIn, int minuteCheckOut) {
        this.car = car;
        this.minuteCheckIn = minuteCheckIn;
        this.minuteCheckOut = minuteCheckOut;
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public Car getCar() {
        return car;
    }
    public int getMinuteCheckIn() {
        return minuteCheckIn;
    }
    public int getMinuteCheckOut() {
        return minuteCheckOut;
    }
    public void setMinuteCheckOut(int minuteCheckOut) {
        this.minuteCheckOut = minuteCheckOut;
    }
}
