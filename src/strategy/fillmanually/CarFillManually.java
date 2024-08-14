package strategy.fillmanually;

import exceptions.ValidateException;
import exceptions.Validation;
import models.Car;

import java.util.Scanner;

public class CarFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually(String dashLine) {
        Car.Builder carBuilder = new Car.Builder();
        boolean status = false;
        Scanner scanner = new Scanner(System.in);
        String input;

        while (!status) {
            try {
                System.out.print("Введите количество лошадей, минимум - 66: ");
                input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
                int power = Validation.carPower(input, dashLine);
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
                input = Validation.removeSymbols(scanner.nextLine());
                carBuilder.model(input);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            try {
                System.out.print("Введите год выпуска в промежутке 1886 - 2024: ");
                input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
                int year = Integer.parseInt(input);
                carBuilder.year(year);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }

        return (T) carBuilder.build();
    }
}
