package menu;

import models.Book;
import models.Car;
import models.RootCrop;
import search.BinarySearch;
import strategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private int arrayLength;
    private final Scanner scanner = new Scanner(System.in);
    private ReadFileContext readFileContext = new ReadFileContext();
    String className = "";
    List<Car> cars = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    List<RootCrop> rootCrops = new ArrayList<>();

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

        String s = "";
        String dashLine = "-------------------------------------------------------------------------------";

        while (!"0".equals(s)) {
            String messageInvalidCommand = dashLine + "\n- Введи нормальную команду";

            messageChooseClass(dashLine);

            className = scanner.next();
            s = className;

            switch (s) {
                case "1":
                    className = "car";
                    break;
                case "2":
                    className = "book";
                    break;
                case "3":
                    className = "rootcrop";
                    break;
                case "9":
                    messageShameOnYou(dashLine);
                    break;
                case "0":
                    continue;
                default:
                    System.out.println(messageInvalidCommand);
                    break;
            }

            messageChooseHowToFillArr(dashLine);

            s = scanner.next();

            switch (s) {
                case "1":
                    fillArray();

                    break;
                case "2":
                    break;
                case "3":
                    inputLength(dashLine);
                    break;
                case "0":
                    continue;
                default:
                    System.out.println(messageInvalidCommand);
                    break;
            }

            messageWantSomeSearch(dashLine);

            String doSearch = scanner.next();
            s = doSearch;

            switch (doSearch) {
                case "1":
                    messageWhatToSearch(dashLine);

                    String searchString = scanner.next().toLowerCase();
                    String[] searchArr = searchString.split(",");
                    String searchClass = searchArr[0];

                    if (searchArr[0].equals(searchString)) {
                        System.out.println(dashLine);
                        System.out.println(messageInvalidCommand);
                        continue;
                    }

                    String searchType = searchArr[1];
                    String searchParam = searchArr[2];

                    BinarySearch.searchResultObject(searchClass, searchType, searchParam, messageInvalidCommand, dashLine, cars);
                    break;
                case "0":
                    break;
                default:
                    System.out.println(dashLine);
                    System.out.println(messageInvalidCommand);
                    break;
            }
        }

        System.out.println(dashLine);
        System.out.println("- До свидания!");
        System.out.println(dashLine);

        scanner.close();
    }

    private void inputLength(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Введите количество элементов массива от 1 до 10:");
        System.out.println(dashLine);

        boolean status = false;
        int length = 0;
        String s = "";

        while (!status) {
            s = scanner.next();

            try {
                length = Integer.parseInt(s);
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

    private void fillArray() {
        switch (className) {
            case "book":
                readFileContext.setReadFileStrategy(new BookReadFile());
                books = readFileContext.executeReadFileStrategy();
                books.forEach(System.out::println);
                break;
            case "car":
                readFileContext.setReadFileStrategy(new CarReadFile());
                cars = readFileContext.executeReadFileStrategy();
                cars.forEach(System.out::println);
                break;
            case "rootcrop":
                readFileContext.setReadFileStrategy(new RootCropReadFile());
                rootCrops = readFileContext.executeReadFileStrategy();
                rootCrops.forEach(System.out::println);
        }
    }
}
