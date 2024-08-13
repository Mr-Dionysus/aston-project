package menu;

import models.Book;
import models.Car;
import models.RootCrop;
import search.BinarySearch;
import sort.MergeSort;
import sort.SortingContext;
import strategy.BookReadFile;
import strategy.CarReadFile;
import strategy.ReadFileContext;
import strategy.RootCropReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private int arrayLength;
    private final Scanner scanner = new Scanner(System.in);
    private SortingContext sortingContext = new SortingContext(null);
    private ReadFileContext readFileContext = new ReadFileContext();
    String className = "";
    String sortBy = "";

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<RootCrop> rootCrops = new ArrayList<>();
    ArrayList list = new ArrayList();

    public void start() {
        String input = "";
        String dashLine = "-------------------------------------------------------------------------------";
        String messageInvalidCommand = dashLine + "\n- Введи нормальную команду";

        while (!"0".equals(input)) {
            Message.chooseClassOption(dashLine);
            className = classOptions(messageInvalidCommand, dashLine);
            input = className;

            if (input.equals("0")) {
                break;
            }

            Message.chooseFillArrOption(dashLine);

            switch (className) {
                case "car":
                    cars = fillArrOptions(messageInvalidCommand, dashLine);
                    break;
                case "book":
                    books = fillArrOptions(messageInvalidCommand, dashLine);
                    break;
                case "rootcrop":
                    rootCrops = fillArrOptions(messageInvalidCommand, dashLine);
                    break;
                default:
                    System.out.println(messageInvalidCommand);
                    break;
            }

            // Стоп, если пользователь выбрал "0"
            if (cars == null || books == null || rootCrops == null) {
                break;
            }

            Message.chooseSortOption(dashLine);
            sortBy = sortOptions(messageInvalidCommand, dashLine);

            if (sortBy.equals("0")) {
                continue;
            }

            Message.chooseYouWantSomeSearch(dashLine);
            switchClassForSearch(messageInvalidCommand, dashLine);
        }

        Message.goodbye(dashLine);
        scanner.close();
    }

    private String classOptions(String messageInvalidCommand, String dashLine) {
        String input = scanner.next();

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
                Message.shameOnYou(dashLine);
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

    private <T> ArrayList<T> fillArrOptions(String messageInvalidCommand, String dashLine) {
        ArrayList<T> list;
        String input = scanner.next();

        switch (input) {
            case "1":
                list = fillArray(messageInvalidCommand);
                return list;
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

        return null;
    }

    private <T> ArrayList<T> fillArray(String messageInvalidCommand) {
        ArrayList<T> list;

        switch (className) {
            case "book":
                readFileContext.setReadFileStrategy(new BookReadFile());
                list = readFileContext.executeReadFileStrategy();
                list.forEach(System.out::println);
                return list;
            case "car":
                readFileContext.setReadFileStrategy(new CarReadFile());
                list = readFileContext.executeReadFileStrategy();
                list.forEach(System.out::println);
                return list;
            case "rootcrop":
                readFileContext.setReadFileStrategy(new RootCropReadFile());
                list = readFileContext.executeReadFileStrategy();
                list.forEach(System.out::println);
                return list;
            default:
                System.out.println(messageInvalidCommand);
                return null;
        }
    }

    private String sortOptions(String messageInvalidCommand, String dashLine) {
        String input = scanner.next();

        switch (input) {
            case "1":
                input = MergeSort.mergeSortArr(className, scanner, sortingContext, cars, books, rootCrops, messageInvalidCommand, dashLine);
                return input;
            case "2":
                MergeSort.mergeSortEvenOddArr(className, scanner, sortingContext, cars, books, messageInvalidCommand, dashLine);
                input = "0";
                return input;
            case "0":
                return input;
            default:
                System.out.println(messageInvalidCommand);
                input = "0";
                return input;
        }
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

    private void switchClassForSearch(String messageInvalidCommand, String dashLine) {
        switch (className) {
            case "car":
                youWantSomeSearch(cars, sortBy, messageInvalidCommand, dashLine);
                break;
            case "book":
                youWantSomeSearch(books, sortBy, messageInvalidCommand, dashLine);
                break;
            case "rootcrop":
                youWantSomeSearch(rootCrops, sortBy, messageInvalidCommand, dashLine);
                break;
            default:
                System.out.println(messageInvalidCommand);
                break;
        }
    }

    private <T> void youWantSomeSearch(ArrayList<T> list, String sortBy, String messageInvalidCommand, String dashLine) {
        String doSearch = scanner.next();
        list.forEach(System.out::println);

        switch (doSearch) {
            case "1":
                Message.writeSearchObject(className, sortBy, dashLine);
                BinarySearch.searchResultObject(list, sortBy, scanner, messageInvalidCommand, dashLine);
                break;
            case "0":
                break;
            default:
                System.out.println(dashLine);
                System.out.println(messageInvalidCommand);
                break;
        }
    }
}
