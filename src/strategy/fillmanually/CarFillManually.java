package strategy.fillmanually;

import exceptions.ValidateException;
import exceptions.Validation;
import menu.Message;
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
                Message.writeCarPower();
                input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
                int power = Validation.carPower(input, dashLine);

                if (power == -1 || power == 0) {
                    return null;
                }

                carBuilder.power(power);
                status = true;
            } catch (ValidateException e) {
                Message.invalidCommand(dashLine);
            }
        }
        status = false;

        while (!status) {
            try {
                Message.writeCarModel();
                input = Validation.removeSymbols(scanner.nextLine());

                if (input.isEmpty()) {
                    Message.emptyString(dashLine);
                    return null;
                } else if (input.equals("0")) {
                    return null;
                }

                carBuilder.model(input);
                status = true;
            } catch (ValidateException e) {
                Message.invalidCommand(dashLine);
            }
        }
        status = false;

        while (!status) {
            try {
                Message.writeCarYear();
                input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
                int year = Validation.carYear(input, dashLine);

                if (year == -1 || year == 0) {
                    return null;
                }

                carBuilder.year(year);
                status = true;
            } catch (ValidateException e) {
                Message.invalidCommand(dashLine);
            }
        }

        return (T) carBuilder.build();
    }
}
