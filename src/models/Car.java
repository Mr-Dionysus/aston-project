package models;

import strategy.CarReadFile;
import strategy.ReadFileStrategy;

import java.util.List;

public class Car {
    private int power = 0;
    private String model;
    private int year;

    private static final ReadFileStrategy readFileStrategy = new CarReadFile();

    public Car(CarBuilder carBuilder) {
        power = carBuilder.power;
        model = carBuilder.model;
        year = carBuilder.year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static class CarBuilder {
        private int power = 0;
        private String model;
        private int year;

        public CarBuilder(int power, String model, int year) {
            this.power = power;
            this.model = model;
            this.year = year;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public static List<Car> ReadFile () {
        return readFileStrategy.ReadFile();
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
