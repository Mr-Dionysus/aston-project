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
        Car car4 = new Car.Builder().power(100).model("Mercedes").year(2005).build();
        Car car5 = new Car.Builder().power(500).model("Mercedes").year(2010).build();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        String s = "";
        String dashLine = "-------------------------------------------------------------------------------";
        String messageInvalidCommand = "- Введи нормальную команду";

        while (!"0".equals(s)) {
            System.out.println(dashLine);
            System.out.println("- Выберите способ заполнения исходного массива:");
            System.out.println("1 - Чтение из файла");
            System.out.println("2 - Случайным образом");
            System.out.println("3 - Ручками");
            System.out.println("9 - Я люблю реализовывать STRATEGY через list.of");
            System.out.println("0 - Выход");
            System.out.println(dashLine);

            s = scanner.next();

            switch (s) {
                case "1":
                    System.out.println("- Это тяжко ...");
                    break;
                case "2":
                    break;
                case "3":
                    inputLength();

                    System.out.println(dashLine);
                    System.out.println("- Объектами какого класса вы хотите заполнить массив?");
                    System.out.println("1 - Машины");
                    System.out.println("2 - Книги");
                    System.out.println("3 - Корнеплоды (клевое название)");
                    System.out.println(dashLine);

                    s = scanner.next();

                    switch (s) {
                        case "1":
                            //car
                            break;
                        case "2":
                            //book
                            break;
                        case "3":
                            //rootcrop
                            break;
                        default:
                            System.out.println(dashLine);
                            System.out.println(messageInvalidCommand);
                            break;
                    }
                    break;
                case "9":
                    System.out.println("- Тьфу на тебя");
                    break;
                case "0":
                    break;
                default:
                    System.out.println(messageInvalidCommand);
                    break;
            }

            System.out.println(dashLine);
            System.out.println("- Хочешь найти нужный тебе объект?");
            System.out.println("1 - Да");
            System.out.println("2 - Нет");
            System.out.println(dashLine);

            String doSearch = scanner.next();

            switch (doSearch) {
                case "1":
                    System.out.println(dashLine);
                    System.out.println("- Напиши, что ты хочешь найти в формате - 'car,power,100'. Варианты:");
                    System.out.println("1 - car (power, model, year)");
                    System.out.println("2 - book (author, name, pages)");
                    System.out.println("3 - rootcrop (type, weight (формат 0.0), color)");

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

                    Car carSearchResult;
                    Book bookSearchResult;
                    RootCrop rootCropSearchResult;
                    int index;

                    String messageInvalidSearchType = messageInvalidCommand + "Ты написал тип " + searchType + ", которого нет у класса " + searchClass + ".";
                    String messageCantFindElement = dashLine + "\nОбъекта с этими данными в массиве нет";

                    switch (searchClass) {
                        case "car":
                            if (searchType.equals("power") || searchType.equals("model") || searchType.equals("year")) {
                                index = BinarySearch.searchResultIndex(searchType, searchParam, cars);

                                if (index == -1) {
                                    System.out.println(messageCantFindElement);
                                } else {
                                    carSearchResult = cars.get(index);
                                    System.out.println(carSearchResult);
                                }
                            } else {
                                System.out.println(messageInvalidSearchType);
                            }
                            break;

                        case "book":
                            if (searchType.equals("author") || searchType.equals("name") || searchType.equals("pages")) {
                                index = BinarySearch.searchResultIndex(searchType, searchParam, books);

                                if (index == -1) {
                                    System.out.println(messageCantFindElement);
                                } else {
                                    bookSearchResult = books.get(index);
                                    System.out.println(bookSearchResult);
                                }
                            } else {
                                System.out.println(messageInvalidSearchType);
                            }
                            break;

                        case "rootcrop":
                            if (searchType.equals("type") || searchType.equals("weight") || searchType.equals("color")) {
                                index = BinarySearch.searchResultIndex(searchType, searchParam, rootCrops);

                                if (index == -1) {
                                    System.out.println(messageCantFindElement);
                                } else {
                                    rootCropSearchResult = rootCrops.get(index);
                                    System.out.println(rootCropSearchResult);
                                }
                            } else {
                                System.out.println(messageInvalidSearchType);
                            }
                            break;
                        default:
                            System.out.println(dashLine);
                            System.out.println(messageInvalidCommand);
                            break;
                    }
                    break;
                case "2":
                    break;
                default:
                    System.out.println(dashLine);
                    System.out.println(messageInvalidCommand);
                    break;
            }
        }

        System.out.println("- До свидания!");
        scanner.close();
    }

    private void inputLength() {
        System.out.println("- Введите количество элементов массива от 1 до 10:");

        boolean status = false;
        int length = 0;
        String s = "";

        while (!status) {
            s = scanner.next();

            try {
                length = Integer.parseInt(s);
                status = setArrayLength(length);
            } catch (NumberFormatException e) {
                System.out.println("- Неверный ввод");
            }
        }
    }

    private boolean setArrayLength(int arrayLength) {
        boolean status = false;

        if (0 < arrayLength && arrayLength <= 10) {
            this.arrayLength = arrayLength;
            status = true;
        } else {
            System.out.println("- Число должно располагаться в диапазоне от 1 до 10");
        }

        return status;
    }
}
