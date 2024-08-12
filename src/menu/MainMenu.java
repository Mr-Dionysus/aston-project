package menu;

import models.Book;
import models.Car;
import models.RootCrop;
import search.BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private int arrayLength;
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<RootCrop> rootCrops = new ArrayList<>();
        ArrayList<Car> carsByYear = new ArrayList<>();

        Car car1 = new Car.Builder().power(100).model("Audi").year(2020).build();
        Car car2 = new Car.Builder().power(100).model("BMW").year(2015).build();
        Car car3 = new Car.Builder().power(100).model("Mercedes").year(2005).build();
        Car car4 = new Car.Builder().power(500).model("Mercedes").year(2010).build();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        String input = "";
        String dashLine = "-------------------------------------------------------------------------------";

        while (!"0".equals(input)) {
            String messageInvalidCommand = dashLine + "\n- Введи нормальную команду";

            messageChooseClass(dashLine);
            String className = chooseClass(input, messageInvalidCommand, dashLine);
            input = className;

            if (input.equals("0")) {
                continue;
            }

            messageChooseHowToFillArr(dashLine);
            input = chooseHotToFillArr(input, messageInvalidCommand, dashLine);

            if (input.equals("0")) {
                continue;
            }

            messageWantSomeSearch(dashLine);
            someSearch(cars, input, messageInvalidCommand, dashLine);
        }

        messageGoodbye(dashLine);
        scanner.close();
    }

    private void inputLength(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Введите количество элементов массива от 1 до 10:");
        System.out.println(dashLine);

        boolean status = false;
        int length = 0;
        String input = "";

        while (!status) {
            input = scanner.next();

            try {
                length = Integer.parseInt(input);
                status = setArrayLength(dashLine, length);
            } catch (NumberFormatException e) {
                System.out.println(dashLine);
                System.out.println("- Неверный ввод");
            }
        }
    }

    private boolean setArrayLength(String dashLine, int arrayLength) {
        boolean status = false;

        if (0 < arrayLength && arrayLength <= 10) {
            this.arrayLength = arrayLength;
            status = true;
        } else {
            System.out.println(dashLine);
            System.out.println("- Число должно располагаться в диапазоне от 1 до 10");
        }

        return status;
    }

    private <T> String someSearch(ArrayList<T> list, String input, String messageInvalidCommand, String dashLine) {
        String doSearch = scanner.next();
        input = doSearch;

        switch (doSearch) {
            case "1":
                messageWhatToSearch(dashLine);
                BinarySearch.searchResultObject(list, scanner, messageInvalidCommand, dashLine);
                break;
            case "0":
                break;
            default:
                System.out.println(dashLine);
                System.out.println(messageInvalidCommand);
                break;
        }

        return input;
    }

    private String chooseHotToFillArr(String input, String messageInvalidCommand, String dashLine) {

        input = scanner.next();

        switch (input) {
            case "1":
                System.out.println("- Это тяжко ...");
                break;
            case "2":
                break;
            case "3":
                inputLength(dashLine);
                break;
            case "0":
                break;
            default:
                System.out.println(messageInvalidCommand);
                break;
        }

        return input;
    }

    private String chooseClass(String input, String messageInvalidCommand, String dashLine) {
        input = scanner.next();

        switch (input) {
            case "1":
                input = "car";
                break;
            case "2":
                input = "book";
                break;
            case "3":
                input = "rootcrop";
                break;
            case "9":
                messageShameOnYou(dashLine);
                break;
            case "0":
                input = "0";
                break;
            default:
                System.out.println(messageInvalidCommand);
                break;
        }

        return input;
    }

    private void messageChooseClass(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Объектами какого класса вы хотите заполнить массив?");
        System.out.println("1 - Машины");
        System.out.println("2 - Книги");
        System.out.println("3 - Корнеплоды (клевое название)");
        System.out.println("9 - Я люблю реализовывать STRATEGY через list.of");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }

    private void messageShameOnYou(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Тьфу на тебя");
        System.out.println(dashLine);
    }

    private void messageChooseHowToFillArr(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Выберите способ заполнения исходного массива:");
        System.out.println("1 - Чтение из файла");
        System.out.println("2 - Случайным образом");
        System.out.println("3 - Ручками");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }

    private void messageWantSomeSearch(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Хочешь найти нужный тебе объект?");
        System.out.println("1 - Да");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }

    private void messageWhatToSearch(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Напиши, что ты ищешь в формате: 'car,power,100'.");
        System.out.println("1 - car (power, model, year)");
        System.out.println("2 - book (author, name, pages)");
        System.out.println("3 - rootcrop (type, weight (формат 0 или 0.0), color)");
        System.out.println(dashLine);
    }

    private void messageGoodbye(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- До свидания!");
        System.out.println(dashLine);
    }
}
