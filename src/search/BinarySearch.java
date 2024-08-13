package search;

import menu.Message;
import models.Book;
import models.Car;
import models.RootCrop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BinarySearch<T> implements SearchingStrategy<T> {
    @Override
    public int search(String searchType, String searchParam, ArrayList<T> list, String dashLine) {
        if (list.isEmpty()) {
            return -1;
        }

        T example = list.get(0);

        if (example instanceof Car) {
            return searchInCars(searchType, searchParam, (ArrayList<Car>) list, dashLine);
        } else if (example instanceof Book) {
            return searchInBooks(searchType, searchParam, (ArrayList<Book>) list, dashLine);
        } else if (example instanceof RootCrop) {
            return searchInRootCrops(searchType, searchParam, (ArrayList<RootCrop>) list, dashLine);
        }
        return -1;
    }

    private int searchInCars(String searchType, String searchParam, ArrayList<Car> list, String dashLine) {
        int index;
        Comparator<Car> carComparator;

        switch (searchType) {
            case "power":
                carComparator = Comparator.comparingInt(Car::getPower);
                index = indexedBinarySearch(list, new Car.Builder().power(Integer.parseInt(searchParam)).model(null).year(0).build(), carComparator);
                return index;
            case "models":
                carComparator = Comparator.comparing(Car::getModel);
                index = indexedBinarySearch(list, new Car.Builder().power(0).model(searchParam).year(0).build(), carComparator);
                return index;
            case "year":
                carComparator = Comparator.comparingInt(Car::getYear);
                index = indexedBinarySearch(list, new Car.Builder().power(0).model(null).year(Integer.parseInt(searchParam)).build(), carComparator);
                return index;
            default:
                return -1;
        }
    }

    private int searchInBooks(String searchType, String searchParam, ArrayList<Book> list, String dashLine) {
        int index;
        Comparator<Book> bookComparator;

        switch (searchType) {
            case "author":
                bookComparator = Comparator.comparing(Book::getAuthor);
                index = indexedBinarySearch(list, new Book.Builder().author(searchParam).name(null).pages(0).build(), bookComparator);
                return index;
            case "name":
                bookComparator = Comparator.comparing(Book::getName);
                index = indexedBinarySearch(list, new Book.Builder().author(null).name(searchParam).pages(0).build(), bookComparator);
                return index;
            case "pages":
                bookComparator = Comparator.comparingInt(Book::getPages);
                index = indexedBinarySearch(list, new Book.Builder().author(null).name(null).pages(Integer.parseInt(searchParam)).build(), bookComparator);
                return index;
            default:
                return -1;
        }
    }

    private int searchInRootCrops(String searchType, String searchParam, ArrayList<RootCrop> list, String dashLine) {
        int index;
        Comparator<RootCrop> rootCropComparator;

        switch (searchType) {
            case "type":
                rootCropComparator = Comparator.comparing(RootCrop::getType);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(searchParam).weight(null).color(null).build(), rootCropComparator);
                return index;
            case "weight":
                rootCropComparator = Comparator.comparingDouble(RootCrop::getWeight);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(null).weight(Double.parseDouble(searchParam)).color(null).build(), rootCropComparator);
                return index;
            case "color":
                rootCropComparator = Comparator.comparing(RootCrop::getColor);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(null).weight(null).color(searchParam).build(), rootCropComparator);
                return index;
            default:
                return -1;
        }
    }

    @SuppressWarnings("ReassignedVariable")
    private static <T> int indexedBinarySearch(ArrayList<? extends T> list, T key, Comparator<? super T> comparator) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = comparator.compare(midVal, key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static <T> T searchResultObject(ArrayList<T> list, Scanner scanner, String messageInvalidCommand, String dashLine) {
        String searchString = scanner.next().toLowerCase();
        String[] searchArr = searchString.split(",");
        String searchClass = searchArr[0];

        if (searchArr.length != 3) {
            System.out.println(dashLine);
            System.out.println(messageInvalidCommand);
        } else {
            String searchType = searchArr[1];
            String searchParam = searchArr[2];
            T searchResult;

            String messageInvalidSearchType = dashLine + "\n" + messageInvalidCommand + "\nТы написал тип " + searchType + ", которого нет у класса " + searchClass + ".";

            switch (searchClass) {
                case "car":
                    if (searchType.equals("power") || searchType.equals("model") || searchType.equals("year")) {
                        searchResult = BinarySearch.searchResultIndex(searchType, searchParam, list, dashLine);
                        return searchResult;
                    } else {
                        System.out.println(messageInvalidSearchType);
                    }
                    break;

                case "book":
                    if (searchType.equals("author") || searchType.equals("name") || searchType.equals("pages")) {
                        searchResult = BinarySearch.searchResultIndex(searchType, searchParam, list, dashLine);
                        return searchResult;
                    } else {
                        System.out.println(messageInvalidSearchType);
                    }
                    break;

                case "rootcrop":
                    if (searchType.equals("type") || searchType.equals("weight") || searchType.equals("color")) {
                        searchResult = BinarySearch.searchResultIndex(searchType, searchParam, list, dashLine);
                        return searchResult;
                    } else {
                        System.out.println(messageInvalidSearchType);
                    }
                    break;
                default:
                    System.out.println(dashLine);
                    System.out.println(messageInvalidCommand);
                    return null;
            }
        }

        return null;
    }

    public static <T> T searchResultIndex(String searchType, String searchParam, ArrayList<T> list, String dashLine) {
        SearchingContext<T> searchingContext = new SearchingContext<>(new BinarySearch<>());
        int index = searchingContext.performSearch(searchType, searchParam, list, dashLine);
        String messageCantFindElement = dashLine + "\nОбъекта с этими данными в массиве нет";
        T searchResult;

        if (index < 0 || index > list.size()) {
            System.out.println(messageCantFindElement);
            return null;
        } else {
            searchResult = list.get(index);

            System.out.println(dashLine);
            System.out.println("Index: " + index);
            System.out.println(searchResult);

            return searchResult;
        }
    }

    public static void someSearchSwitchCarBookRootCrop(String className, ArrayList cars, ArrayList books, ArrayList rootCrops, ArrayList list, Scanner scanner, String messageInvalidCommand, String dashLine) {
        switch (className) {
            case "car":
                cars = list;
                someSearch(scanner, cars, messageInvalidCommand, dashLine);
                break;
            case "book":
                books = list;
                someSearch(scanner, books, messageInvalidCommand, dashLine);
                break;
            case "rootcrop":
                rootCrops = list;
                someSearch(scanner, rootCrops, messageInvalidCommand, dashLine);
                break;
            default:
                System.out.println(messageInvalidCommand);
                break;
        }
    }

    public static <T> void someSearch(Scanner scanner, ArrayList<T> list, String messageInvalidCommand, String dashLine) {
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
}
