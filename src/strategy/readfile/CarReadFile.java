package strategy.readfile;

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
                int power = Integer.parseInt(values[0]);
                String model = values[1];
                int year = Integer.parseInt(values[2]);
                Car car = new Car.Builder().power(power).model(model).year(year).build();
                carList.add(car);
            }
        } catch (IOException e) {
            System.out.println("Exception\n");
            carList = null;
        }
        return carList;
    }
}
