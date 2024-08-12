package menu;

import java.util.Scanner;

public class MainMenu {
    private int arrayLength;

    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        String s = "";

        while (!"0".equals(s)) {
            System.out.println("Выберите способ заполнения исходного массива:");
            System.out.println("1 - Чтение из файла");
            System.out.println("2 - Рандомное заполнение");
            System.out.println("3 - Ручками");
            System.out.println("0 - Выход");

            s = scanner.next();
            switch (s) {
                case "1":
                    System.out.println("Это тяжко ...");
                    break;
                case "2":
                case "3":
                    inputLength();
                    break;
                default:
                    System.out.println("Введи нормальную команду");
            }
        }
        System.out.println("До свидания!");
        scanner.close();
    }

    private void inputLength() {
        System.out.println("Введите количество элементов массива от 1 до 10:");
        boolean status = false;
        int length = 0;
        String s = "";
        while (!status) {
            s = scanner.next();
            try {
                length = Integer.parseInt(s);
                status = setArrayLength(length);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        }
    }

    private boolean setArrayLength(int arrayLength) {
        boolean status = false;
        if (0 < arrayLength && arrayLength <= 10) {
            this.arrayLength = arrayLength;
            status = true;
        } else {
            System.out.println("Число должно располагаться в диапазоне от 1 до 10");
        }

        return status;
    }


}
