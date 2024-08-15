package fillArr.readFile;

import models.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CarReadFile implements ReadFileStrategy {
    @Override
    public ArrayList<Car> readFile() {
        ArrayList<Car> cars = new ArrayList<>();
        String input;
        // Чтение данных из файла
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/cars.txt"))) {
            while ((input = reader.readLine()) != null) {
                String[] values = input.split(":", 3);
                int power = Integer.parseInt(values[0]);
                String model = values[1];
                int year = Integer.parseInt(values[2]);
                Car car = new Car.Builder().power(power).model(model).year(year).build();
                cars.add(car);
            }
        } catch (IOException e) {
            System.out.println("Exception\n");
            cars = null;
        }
        return cars;
    }
}
