package strategy.fillmanually;

import exceptions.ValidateException;
import models.Car;

import java.util.Scanner;

public class CarFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually(String dashLine) {
        Car.Builder carBuilder = new Car.Builder();
        boolean status = false;
        Scanner scanner = new Scanner(System.in);
        String line;

        while (!status) {
            try {
                System.out.print("Введите количество лошадей: ");
                line = scanner.next();
                int power = Integer.parseInt(line);
                carBuilder.power(power);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            try {
                System.out.print("Введите название машины: ");
                line = scanner.next();
                carBuilder.model(line);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            try {
                System.out.print("Введите год выпуска: ");
                line = scanner.next();
                int year = Integer.parseInt(line);
                carBuilder.year(year);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }

        return (T) carBuilder.build();
    }
}
