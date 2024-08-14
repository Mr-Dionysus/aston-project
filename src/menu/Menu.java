package menu;

import models.Book;
import models.Car;
import models.RootCrop;
import search.Search;
import sort.MergeSort;
import sort.MergeSortEvenOdd;
import sort.SortingContext;
import strategy.fillmanually.BookFillManually;
import strategy.fillmanually.CarFillManually;
import strategy.fillmanually.FillManuallyContext;
import strategy.fillmanually.RootCropFillManually;
import strategy.readfile.BookReadFile;
import strategy.readfile.CarReadFile;
import strategy.readfile.ReadFileContext;
import strategy.readfile.RootCropReadFile;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private int arrayLength;
    private final Scanner scanner = new Scanner(System.in);
    private final SortingContext sortingContext = new SortingContext(null);
    private final ReadFileContext readFileContext = new ReadFileContext();
    private final FillManuallyContext fillManuallyContext = new FillManuallyContext();
    String className = "";
    String sortBy = "";

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<RootCrop> rootCrops = new ArrayList<>();


    public void start() {
        String input;

        outside:
        while (true) {
            // Выбор класса объектов
            Message.chooseClassOption();
            className = classOptions();
            input = className;

            if (input.equals("0")) {
                break;
            }
            // ----------------------------------------------------
            // Выбор метода заполнения
            Message.chooseFillArrOption();

            switch (className) {
                case "car":
                    MergeSortEvenOdd.setSortType("Year");
                    cars = fillArrOptions();
                    // Закрыть программу если пользователь так решил или ввел неверно первый объект
                    if (cars == null || cars.getFirst() == null) {
                        break outside;
                    } else if (cars.contains(null)) {
                        cars.removeIf(Objects::isNull);
                    }
                    break;
                case "book":
                    MergeSortEvenOdd.setSortType("Pages");
                    books = fillArrOptions();

                    if (books == null || books.getFirst() == null) {
                        break outside;
                    } else if (books.contains(null)) {
                        books.removeIf(Objects::isNull);
                    }
                    break;
                case "rootcrop":
                    rootCrops = fillArrOptions();

                    if (rootCrops == null || rootCrops.getFirst() == null) {
                        break outside;
                    } else if (rootCrops.contains(null)) {
                        rootCrops.removeIf(Objects::isNull);
                    }
                    break;
                default:
                    Message.invalidCommand();
                    break;
            }
            // ----------------------------------------------------
            //Выбор метода сортировки
            Message.chooseSortOption();
            sortBy = sortOptions();

            if (sortBy.equals("0")) {
                continue;
            }

            Message.chooseYouWantSomeSearch();
            Search.switchClassForSearch(scanner, className, sortBy, cars, books, rootCrops);
        }

        Message.goodbye();
        scanner.close();
    }

    // Выбор класса для заполнения
    private String classOptions() {
        String input = scanner.next().replaceAll("[^\\w\\s]|_", "");

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
                Message.shameOnYou();
                break;
            case "0":
                input = "0";
                break;
            default:
                Message.invalidCommand();
                break;
        }

        return input;
    }

    private <T> ArrayList<T> fillArrOptions() {
        ArrayList<T> list = null;
        String input = scanner.next().replaceAll("[^\\w\\s]|_", "");

        switch (input) {
            case "1":
                list = fillArray();
                return list;
            case "2":
                inputLength();
                list = fillArrayRand(arrayLength);
                return list;
            case "3":
                // SSV
                inputLength();
                list = fillArrayManually();
                break;
            case "0":
                break;
            default:
                Message.invalidCommand();
                break;
        }

        return list;
    }

    private <T> ArrayList<T> fillArrayManually() {
        ArrayList<T> list = new ArrayList<>();
        switch (className) {
            case "book":
                fillManuallyContext.setFillManuallyStrategy(new BookFillManually());
                break;
            case "car":
                fillManuallyContext.setFillManuallyStrategy(new CarFillManually());
                break;
            case "rootcrop":
                fillManuallyContext.setFillManuallyStrategy(new RootCropFillManually());
                break;
        }
        for (int i = 1; i <= arrayLength; i++) {
            if (className.equals("book")) {
                Message.dashLine();
                System.out.printf("Заполняем %d книгу\n", i);
            } else if (className.equals("car")) {
                Message.dashLine();
                System.out.printf("Заполняем %d машину\n", i);
            } else if (className.equals("rootcrop")) {
                Message.dashLine();
                System.out.printf("Заполняем %d корнеплод\n", i);
            }
            list.add((T) fillManuallyContext.executeFillManually());
        }
        return list;
    }

    private <T> ArrayList<T> fillArray() {
        ArrayList<T> list;
        switch (className) {
            case "book":
                readFileContext.setReadFileStrategy(new BookReadFile());
                break;
            case "car":
                readFileContext.setReadFileStrategy(new CarReadFile());
                break;
            case "rootcrop":
                readFileContext.setReadFileStrategy(new RootCropReadFile());
                break;
            default:
                Message.invalidCommand();
        }
        list = readFileContext.executeReadFileStrategy();
        Message.dashLine();
        list.forEach(System.out::println);

        return list;
    }

    private <T> ArrayList<T> fillArrayRand(int arrayLength) {
        ArrayList<T> list;

        switch (className) {
            case "book":
                list = (ArrayList<T>) Book.createObjects(arrayLength);
                Message.dashLine();
                list.forEach(System.out::println);
                return list;
            case "car":
                list = (ArrayList<T>) Car.createObjects(arrayLength);
                Message.dashLine();
                list.forEach(System.out::println);
                return list;
            case "rootcrop":
                list = (ArrayList<T>) RootCrop.createObjects(arrayLength);
                Message.dashLine();
                list.forEach(System.out::println);
                return list;
            default:
                Message.invalidCommand();
                return null;
        }
    }

    private String sortOptions() {
        String input = scanner.next();

        switch (input) {
            case "1":
                input = MergeSort.mergeSortArr(className, scanner, sortingContext, cars, books, rootCrops);
                return input;
            case "2":
                MergeSortEvenOdd.setIsEven(true);
                MergeSortEvenOdd.mergeSortedArrEvenOdd(className, scanner, sortingContext, cars, books);
                input = "0";
                return input;
            case "3":
                MergeSortEvenOdd.setIsEven(false);
                MergeSortEvenOdd.mergeSortedArrEvenOdd(className, scanner, sortingContext, cars, books);
                input = "0";
                return input;
            case "0":
                return input;
            default:
                Message.invalidCommand();
                input = "0";
                return input;
        }
    }

    private void inputLength() {
        Message.writeArrLength();

        boolean status = false;
        int length;
        String input;

        while (!status) {
            input = scanner.next();
            try {
                length = Integer.parseInt(input);
                status = setArrayLength(length);
            } catch (NumberFormatException e) {
                Message.invalidCommand();
            }
        }
    }

    private boolean setArrayLength(int arrayLength) {
        boolean status = false;

        if (0 < arrayLength && arrayLength <= 10) {
            this.arrayLength = arrayLength;
            status = true;
        } else {
            Message.wrongArrLength();
        }

        return status;
    }
}
