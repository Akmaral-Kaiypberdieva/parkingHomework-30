package models;

public class Magazine {
    private Car car;
    private int minuteCheckIn;
    private int minuteCheckOut;
    private int day;
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

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
