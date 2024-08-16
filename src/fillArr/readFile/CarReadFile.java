package fillArr.readFile;

import models.Car;
import validation.Validation;

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
                String powerString = Validation.removeSymbolsLettersSpaces(values[0]);
                int power = Validation.carPower(powerString);

                String model = Validation.removeSymbols(values[1]);

                String yearString = Validation.removeSymbolsWithoutDotLettersSpaces(values[2]);
                int year = Validation.carYear(yearString);
                Car car = new Car.Builder().power(power).model(model).year(year).build();

                if (power == -1 || year == -1) {
                    car = null;
                }

                cars.add(car);
            }
        } catch (IOException e) {
            System.out.println("Exception\n");
            cars = null;
        }
        return cars;
    }
}
