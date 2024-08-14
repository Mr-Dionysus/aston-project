package strategy.fillmanually;

import exceptions.ValidateException;
import exceptions.Validation;
import menu.Message;
import models.RootCrop;

import java.util.Scanner;

public class RootCropFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually() {
        RootCrop.Builder rootCropBuilder = new RootCrop.Builder();
        boolean status = false;
        Scanner scanner = new Scanner(System.in);
        String input;

        while (!status) {
            try {
                Message.writeRootCropType();
                input = Validation.removeSymbolsNums(scanner.nextLine());

                if (input.isEmpty()) {
                    Message.emptyString();
                    return null;
                } else if (input.equals("stop")) {
                    return null;
                }

                rootCropBuilder.type(input);
                status = true;
            } catch (ValidateException e) {
                Message.invalidCommand();
            }
        }
        status = false;

        while (!status) {
            try {
                Message.writeRootCropWeight();
                input = Validation.removeSymbolsWithoutDotLettersSpaces(scanner.nextLine());
                double weight = Validation.rootCropWeight(input);

                if (weight == -1 || weight == 0) {
                    return null;
                }

                rootCropBuilder.weight(weight);
                status = true;
            } catch (ValidateException | NumberFormatException e) {
                Message.invalidCommand();
            }
        }
        status = false;

        while (!status) {
            try {
                Message.writeRootCropColor();
                input = Validation.removeSymbolsNums(scanner.nextLine());

                if (input.isEmpty()) {
                    Message.emptyString();
                    return null;
                } else if (input.equals("stop")) {
                    return null;
                }

                rootCropBuilder.color(input);
                status = true;
            } catch (ValidateException e) {
                Message.invalidCommand();
            }
        }

        return (T) rootCropBuilder.build();
    }
}
