package search;

import menu.Message;
import models.Book;
import models.Car;
import models.RootCrop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BinarySearch<T> implements SearchingStrategy<T> {
    public static <T> T classOptionsForSearch(ArrayList<T> list, String className, String sortBy, Scanner scanner, String messageInvalidCommand, String dashLine) {
        scanner.nextLine();
        String searchParam = scanner.nextLine().toLowerCase();

        if (searchParam.isEmpty()) {
            Message.emptyString(dashLine);
            return null;
        }

        switch (className) {
            case "car", "book", "rootcrop":
                BinarySearch.searchResultObject(searchParam, sortBy, list, dashLine);
                break;

            default:
                System.out.println(messageInvalidCommand);
                break;
        }
        return null;
    }

    public static <T> T searchResultObject(String searchParam, String sortBy, ArrayList<T> list, String dashLine) {
        SearchingContext<T> searchingContext = new SearchingContext<>(new BinarySearch<>());
        int index = searchingContext.performSearch(sortBy, searchParam, list, dashLine);
        T searchResult;

        if (index < 0 || index > list.size()) {
            Message.cantFindObject(dashLine);
            return null;
        } else {
            searchResult = list.get(index);
            Message.searchResultWithIndex(index, searchResult, dashLine);
            return searchResult;
        }
    }

    @Override
    public int search(String searchType, String searchParam, ArrayList<T> list, String dashLine) {
        if (list.isEmpty()) {
            return -1;
        }
        T example = list.getFirst();

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
                try {
                    Integer.parseInt(searchParam);
                } catch (NumberFormatException e) {
                    Message.wrongFormatNum(dashLine);
                    return -1;
                }

                carComparator = Comparator.comparingInt(Car::getPower);
                index = indexedBinarySearch(list, new Car.Builder().power(Integer.parseInt(searchParam)).model(null).year(0).build(), carComparator);
                return index;
            case "model":
                carComparator = Comparator.comparing(Car::getModel);
                index = indexedBinarySearch(list, new Car.Builder().power(0).model(searchParam).year(0).build(), carComparator);
                return index;
            case "year":
                try {
                    Integer.parseInt(searchParam);
                } catch (NumberFormatException e) {
                    Message.wrongFormatNum(dashLine);
                    return -1;
                }

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
                try {
                    Integer.parseInt(searchParam);
                } catch (NumberFormatException e) {
                    Message.wrongFormatNum(dashLine);
                    return -1;
                }

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
                index = indexedBinarySearch(list, new RootCrop.Builder().type(searchParam).weight(0.0).color(null).build(), rootCropComparator);
                return index;
            case "weight":
                try {
                    Double.parseDouble(searchParam);
                } catch (NumberFormatException e) {
                    Message.wrongFormatNum(dashLine);
                    return -1;
                }

                rootCropComparator = Comparator.comparingDouble(RootCrop::getWeight);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(null).weight(Double.parseDouble(searchParam)).color(null).build(), rootCropComparator);
                return index;
            case "color":
                rootCropComparator = Comparator.comparing(RootCrop::getColor);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(null).weight(0.0).color(searchParam).build(), rootCropComparator);
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
}
