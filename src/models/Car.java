package models;

import strategy.CarReadFile;
import strategy.ReadFileStrategy;

import java.util.List;
import java.util.Random;

public class Car {
    private final int power;
    private final String model;
    private final int year;

    private static final ReadFileStrategy readFileStrategy = new CarReadFile();
    static String[] models = {"Lada Granta", "Kia Rio", "Toyota Camry","Ford Mustang","Honda Civic","Tesla Model S",
            "BMW X5","Mercedes-Benz E-Class","Subaru Outback","Jeep Wrangler","Audi Q7","Nissan Altima",
            "Volkswagen Golf","Porsche 911","Kia Sorento","Dodge Charger","Cadillac Escalade","Lexus RX"};
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
        return "power=" + power +
                ", model='" + model + '\'' +
                ", year=" + year;
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

    public static Car[] createObjects(int n){
        Car[] cars = new Car[n];

        for (int i = 0; i < cars.length;i++){
            cars[i] = new Car.Builder().power(randomPower()).model(randomModel()).year(randomYear()).build();
            System.out.println(cars[i].toString());
        }
        return cars;
    }

    static Random random = new Random();

    private static int randomYear() {
        return random.nextInt(1800,2050);
    }

    private static int randomPower() {
        return random.nextInt(1,1000);
    }

    private static String randomModel() {
        return models[random.nextInt(1,models.length)];
    }

}
