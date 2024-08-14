package strategy.fillmanually;

import exceptions.ValidateException;
import models.RootCrop;

import java.util.Scanner;

public class RootCropFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually() {
        RootCrop.Builder rootCropBuilder = new RootCrop.Builder();
        boolean status = false;
        Scanner scanner = new Scanner(System.in);
        String line;

        while (!status) {
            try {
                System.out.print("Введите тип корнеплода: ");
                line = scanner.next();
                rootCropBuilder.type(line);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            try {
                System.out.print("Введите вес корнеплода: ");
                line = scanner.next();
                double weight = Double.parseDouble(line);
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
                line = scanner.next();
                rootCropBuilder.color(line);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }

        return (T) rootCropBuilder.build();
    }
}
