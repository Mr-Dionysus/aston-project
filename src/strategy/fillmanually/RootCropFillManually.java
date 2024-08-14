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
        String input;
        double weight;

        while (!status) {
                System.out.print("Введите тип корнеплода: ");
                input = scanner.nextLine();
                rootCropBuilder.type(input);
                status = true;
        }
        status = false;

        while (!status) {
                System.out.print("Введите вес корнеплода: ");
                input = scanner.nextLine();
                if (input.matches("^[0-9]+(\\.[0-9]*$)?")) {
                    weight = Double.parseDouble(input);
                    rootCropBuilder.weight(weight);
                    status = true;
                }else{System.out.println("Неверные данные");}
        }
        status = false;

        while (!status) {
                System.out.print("Введите цвет корнеплода: ");
                input = scanner.nextLine();
                rootCropBuilder.color(input);
                status = true;
        }

        return (T) rootCropBuilder.build();
    }
}
