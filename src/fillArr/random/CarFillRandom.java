package fillArr.random;

import models.Car;

import java.util.ArrayList;
import java.util.Random;

public class CarFillRandom implements FillRandomStrategy{
    // Данные для случайной генерации объекта
    String[] models = {"Lada Granta", "Kia Rio", "Toyota Camry", "Ford Mustang", "Honda Civic", "Tesla Model S", "BMW X5", "Mercedes-Benz E-Class", "Subaru Outback", "Jeep Wrangler", "Audi Q7", "Nissan Altima", "Volkswagen Golf", "Porsche 911", "Kia Sorento", "Dodge Charger", "Cadillac Escalade", "Lexus RX"};

    Random random = new Random();

    private int randomYear() {
        return random.nextInt(1990, 2024);
    }

    private int randomPower() {
        return random.nextInt(1, 1000);
    }

    private  String randomModel() {
        return models[random.nextInt(1, models.length)];
    }

    @Override
    public ArrayList<Car> fillRandom(int size) {
        ArrayList<Car> carList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            carList.add(new Car.Builder().power(randomPower()).model(randomModel()).year(randomYear()).build());
        }
        return carList;
    }
}


