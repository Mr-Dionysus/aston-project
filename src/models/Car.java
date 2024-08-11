package models;

import strategy.CarReadFile;
import strategy.ReadFileStrategy;

import java.util.List;

public class Car {
    private final int power;
    private final String model;
    private final int year;

    private static final ReadFileStrategy readFileStrategy = new CarReadFile();

    Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public static List<models.Car> ReadFile() {
        return readFileStrategy.ReadFile();
    }

    @Override
    public String toString() {
        return "Power: " + this.power + "\nModel: " + this.model + "\nYear:  " + this.year;
    }

    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
