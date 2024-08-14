package strategy.fillmanually;

import exceptions.ValidateException;
import models.Car;

import java.util.Scanner;

public class CarFillManually implements FillManuallyStrategy {
	@Override
	public <T> T fillManually() {
		Car.Builder carBuilder = new Car.Builder();
		boolean status = false;
		Scanner scanner = new Scanner(System.in);
		String line;
		int power;

		while (!status) {
			System.out.print("Введите количество лошадей: ");
			line = scanner.nextLine();
			if (line.matches("^[0-9]+$")) {
				power = Integer.parseInt(line);
				carBuilder.power(power);
				status = true;
			} else {
				System.out.println("Неверные данные");
			}
		}
		status = false;

		while (!status) {
			System.out.print("Введите название машины: ");
			line = scanner.nextLine();
			carBuilder.model(line);
			status = true;
		}
		status = false;

		while (!status) {
			System.out.print("Введите год выпуска: ");
			line = scanner.next();
			if(line.matches("^[0-9]+$")) {
				int year = Integer.parseInt(line);
				carBuilder.year(year);
				status = true;
			}else {
				System.out.println("Неверные данные");
			}
		}

		return (T) carBuilder.build();
	}
}
