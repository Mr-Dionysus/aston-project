package strategy.readfile;

import exceptions.ValidateException;
import models.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CarReadFile implements ReadFileStrategy {
    @Override
    public ArrayList<Car> readFile() {
        ArrayList<Car> carList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/cars.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(":", 3);
                if (values.length == 3) {
                    int power = Integer.parseInt(values[0]);
                    String model = values[1];
                    int year = Integer.parseInt(values[2]);
                    Car car = new Car.Builder().power(power).model(model).year(year).build();
                    carList.add(car);
                }
            }
        } catch (IOException | ValidateException | NumberFormatException e) {
            System.out.println("Некоректные данные в файле");
            carList = null;
        }
        return carList;
    }
}
