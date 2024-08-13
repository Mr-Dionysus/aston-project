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

public class App {
    private int arrayLength;
    private final Scanner scanner = new Scanner(System.in);
    private SortingContext sortingContext = new SortingContext(null);
    private ReadFileContext readFileContext = new ReadFileContext();
    String className = "";

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<RootCrop> rootCrops = new ArrayList<>();
    ArrayList list = new ArrayList();

    public void start() {
        String input = "";
        String dashLine = "-------------------------------------------------------------------------------";

        while (!"0".equals(input)) {
            String messageInvalidCommand = dashLine + "\n- Введи нормальную команду";

            Message.chooseClass(dashLine);
            className = chooseClass(messageInvalidCommand, dashLine);
            input = className;

            if (input.equals("0")) {
                continue;
            }

            Message.chooseHowToFillArr(dashLine);


            switch (className) {
                case "car":
                    cars = chooseHowToFillArr(messageInvalidCommand, dashLine);
                    break;
                case "book":
                    books = chooseHowToFillArr(messageInvalidCommand, dashLine);
                    break;
                case "rootcrop":
                    rootCrops = chooseHowToFillArr(messageInvalidCommand, dashLine);
                    break;
                default:
                    System.out.println(messageInvalidCommand);
                    break;
            }

            Message.chooseSortOption(dashLine);

            input = sortArr(messageInvalidCommand, dashLine);

            if (input.equals("0")) {
                continue;
            }

            Message.wantSomeSearch(dashLine);

            switch (className) {
                case "car":
                    someSearch(cars, messageInvalidCommand, dashLine);
                    break;
                case "book":
                    someSearch(books, messageInvalidCommand, dashLine);
                    break;
                case "rootcrop":
                    someSearch(rootCrops, messageInvalidCommand, dashLine);
                    break;
                default:
                    System.out.println(messageInvalidCommand);
                    break;
            }
        }

        Message.goodbye(dashLine);
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

    private <T> void someSearch(ArrayList<T> list, String messageInvalidCommand, String dashLine) {
        String doSearch = scanner.next();
        list.forEach(System.out::println);

        switch (doSearch) {
            case "1":
                Message.whatToSearch(dashLine);
                BinarySearch.searchResultObject(list, scanner, messageInvalidCommand, dashLine);
                break;
            case "0":
                break;
            default:
                System.out.println(dashLine);
                System.out.println(messageInvalidCommand);
                break;
        }
    }

    private <T> ArrayList<T> chooseHowToFillArr(String messageInvalidCommand, String dashLine) {
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

    private String chooseClass(String messageInvalidCommand, String dashLine) {
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

    private String sortArr(String messageInvalidCommand, String dashLine) {
        String input = scanner.next();

        switch (input) {
            case "1":
                MergeSort.mergeSortArr(className, scanner, sortingContext, cars, books, rootCrops, messageInvalidCommand, dashLine);
                return input;
            case "2":
                MergeSort.mergeSortEvenOddArr(className, scanner, sortingContext, cars, books, messageInvalidCommand, dashLine);
                return input;
            case "0":
                return input;
            default:
                System.out.println(messageInvalidCommand);
                return input;
        }
    }
}
