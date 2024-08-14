package strategy.fillmanually;

import exceptions.ValidateException;
import models.Car;

import java.util.Scanner;

public class CarFillManually<T> implements FillManuallyStrategy {
	@Override
	public <T> T fillManually() {
		Car.Builder carBuilder = new Car.Builder();
		boolean status = false;
		Scanner scanner = new Scanner(System.in);
		String input;
		int power;
		int year;

		while (!status) {
			System.out.print("Введите количество лошадей: ");
			input = scanner.nextLine();
			if (input.matches("^[0-9]+$")) {
				power = Integer.parseInt(input);
				carBuilder.power(power);
				status = true;
			} else {
				System.out.println("Неверные данные");
			}
		}
		status = false;

		while (!status) {
			System.out.print("Введите название машины: ");
			input = scanner.nextLine();
			carBuilder.model(input);
			status = true;
		}
		status = false;

		while (!status) {
			System.out.print("Введите год выпуска: ");
			input = scanner.next();
			if(input.matches("^[0-9]+$")) {
				year = Integer.parseInt(input);
				carBuilder.year(year);
				status = true;
			}else {
				System.out.println("Неверные данные");
			}
		}

		return (T) carBuilder.build();
	}
}
