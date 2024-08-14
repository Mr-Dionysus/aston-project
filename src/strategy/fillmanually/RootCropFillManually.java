package strategy.fillmanually;

import exceptions.ValidateException;
import exceptions.Validation;
import models.RootCrop;

import java.util.Scanner;

public class RootCropFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually(String dashLine) {
        RootCrop.Builder rootCropBuilder = new RootCrop.Builder();
        boolean status = false;
        Scanner scanner = new Scanner(System.in);
        String input;

        while (!status) {
            try {
                System.out.print("Введите тип корнеплода: ");
                input = Validation.removeSymbolsNums(scanner.nextLine());
                rootCropBuilder.type(input);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            try {
                System.out.print("Введите вес корнеплода: ");
                input = Validation.removeSymbolsWithoutDotLettersSpaces(scanner.nextLine());
                double weight = Double.parseDouble(input);
                rootCropBuilder.weight(weight);
                status = true;
            } catch (ValidateException | NumberFormatException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            try {
                System.out.print("Введите цвет корнеплода: ");
                input = Validation.removeSymbolsNums(scanner.nextLine());
                rootCropBuilder.color(input);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }

        return (T) rootCropBuilder.build();
    }
}
