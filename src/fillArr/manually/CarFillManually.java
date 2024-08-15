package fillArr.manually;

import menu.Err;
import menu.Message;
import models.Car;
import validation.Validation;

import java.util.Scanner;

public class CarFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually() {
        Car.Builder carBuilder = new Car.Builder();
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean status = false;
        // Ввод мощности
        while (!status) {
            Message.writeCarPower();
            input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
            int power = Validation.carPower(input);

            if (power == -1 || power == 0) {
                return null;
            }

            carBuilder.power(power);
            status = true;
        }

        status = false;
        // Ввод модели
        while (!status) {
            Message.writeCarModel();
            input = Validation.removeSymbols(scanner.nextLine());

            if (input.isEmpty()) {
                Err.emptyString();
                return null;
            } else if (input.equals("0")) {
                return null;
            }

            carBuilder.model(input);
            status = true;
        }

        status = false;
        // Ввод года
        while (!status) {
            Message.writeCarYear();
            input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
            int year = Validation.carYear(input);

            if (year == -1 || year == 0) {
                return null;
            }

            carBuilder.year(year);
            status = true;
        }

        return (T) carBuilder.build();
    }
}
