package models;

import java.util.ArrayList;
import java.util.Random;

public class Car {
    private final int power;
    private final String model;
    private final int year;
    // Данные для случайной генерации объекта
    static String[] models = {"Lada Granta", "Kia Rio", "Toyota Camry", "Ford Mustang", "Honda Civic", "Tesla Model S", "BMW X5", "Mercedes-Benz E-Class", "Subaru Outback", "Jeep Wrangler", "Audi Q7", "Nissan Altima", "Volkswagen Golf", "Porsche 911", "Kia Sorento", "Dodge Charger", "Cadillac Escalade", "Lexus RX"};

    Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model.toLowerCase();
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Power: " + this.power + " | Model: " + this.model + " | Year: " + this.year;
    }

    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder power(int power) {
            //            if (power > 0 && power <= 1000) {
            //                this.power = power;
            //            } else {
            //                throw new ValidateException("Ошибка валидации");
            //            }
            this.power = power;
            return this;
        }

        public Builder model(String model) {
            //            if (!model.isEmpty() && !model.matches("-?\\d+")) {
            //                this.model = model;
            //            } else {
            //                throw new ValidateException("Ошибка валидации");
            //            }
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            //            if (year > 1800 && year <= 2024 || year == 0) {
            //                this.year = year;
            //            } else {
            //                throw new ValidateException("Ошибка валидации");
            //            }
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    // Создание случайной машины
    public static ArrayList<Car> createObjects(int length) {
        ArrayList<Car> carList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            carList.add(new Car.Builder().power(randomPower()).model(randomModel()).year(randomYear()).build());
        }
        return carList;
    }

    static Random random = new Random();

    private static int randomYear() {
        return random.nextInt(1990, 2024);
    }

    private static int randomPower() {
        return random.nextInt(1, 1000);
    }

    private static String randomModel() {
        return models[random.nextInt(1, models.length)];
    }
}
