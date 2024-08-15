package fillArr.manually;

import menu.Err;
import menu.Message;
import models.RootCrop;
import validation.Validation;

import java.util.Scanner;

public class RootCropFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually() {
        RootCrop.Builder rootCropBuilder = new RootCrop.Builder();
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean status = false;
        // Ввод типа
        while (!status) {
            Message.writeRootCropType();
            input = Validation.removeSymbolsNums(scanner.nextLine());

            if (input.isEmpty()) {
                Err.emptyString();
                return null;
            } else if (input.equals("stop")) {
                return null;
            }

            rootCropBuilder.type(input);
            status = true;
        }
        status = false;
        // Ввод веса
        while (!status) {
            Message.writeRootCropWeight();
            input = Validation.removeSymbolsWithoutDotLettersSpaces(scanner.nextLine());
            double weight = Validation.rootCropWeight(input);

            if (weight == -1 || weight == 0) {
                return null;
            }

            rootCropBuilder.weight(weight);
            status = true;
        }
        status = false;
        // Ввод цвета
        while (!status) {
            Message.writeRootCropColor();
            input = Validation.removeSymbolsNums(scanner.nextLine());

            if (input.isEmpty()) {
                Err.emptyString();
                return null;
            } else if (input.equals("stop")) {
                return null;
            }

            rootCropBuilder.color(input);
            status = true;
        }

        return (T) rootCropBuilder.build();
    }
}
