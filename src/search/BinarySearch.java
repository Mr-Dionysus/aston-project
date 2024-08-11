package search;

import models.Book;
import models.Car;
import models.RootCrop;

import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearch<T> implements SearchingStrategy<T> {
    @Override
    public int search(String searchType, String searchParam, ArrayList<T> list) {
        if (list.isEmpty()) {
            return -1;
        }

        T example = list.getFirst();

        if (example instanceof Car) {
            return searchInCars(searchType, searchParam, (ArrayList<Car>) list);
        } else if (example instanceof Book) {
            return searchInBooks(searchType, searchParam, (ArrayList<Book>) list);
        } else if (example instanceof RootCrop) {
            return searchInRootCrops(searchType, searchParam, (ArrayList<RootCrop>) list);
        }
        return -1;
    }

    private int searchInCars(String searchType, String searchParam, ArrayList<Car> list) {
        int index;
        Comparator<Car> carComparator;

        switch (searchType) {
            case "power":
                carComparator = Comparator.comparingInt(Car::getPower);
                index = indexedBinarySearch(list, new Car.Builder().power(Integer.parseInt(searchParam)).model(null).year(0).build(), carComparator);
                break;
            case "models":
                carComparator = Comparator.comparing(Car::getModel);
                index = indexedBinarySearch(list, new Car.Builder().power(0).model(searchParam).year(0).build(), carComparator);
                break;
            case "year":
                carComparator = Comparator.comparingInt(Car::getYear);
                index = indexedBinarySearch(list, new Car.Builder().power(0).model(null).year(Integer.parseInt(searchParam)).build(), carComparator);
                break;
            default:
                index = -1;
                break;
        }
        return index;
    }

    private int searchInBooks(String searchType, String searchParam, ArrayList<Book> list) {
        int index;
        Comparator<Book> bookComparator;

        switch (searchType) {
            case "author":
                bookComparator = Comparator.comparing(Book::getAuthor);
                index = indexedBinarySearch(list, new Book.Builder().author(searchParam).name(null).pages(0).build(), bookComparator);
                break;
            case "name":
                bookComparator = Comparator.comparing(Book::getName);
                index = indexedBinarySearch(list, new Book.Builder().author(null).name(searchParam).pages(0).build(), bookComparator);
                break;
            case "pages":
                bookComparator = Comparator.comparingInt(Book::getPages);
                index = indexedBinarySearch(list, new Book.Builder().author(null).name(null).pages(Integer.parseInt(searchParam)).build(), bookComparator);
                break;
            default:
                index = -1;
                break;
        }
        return index;
    }

    private int searchInRootCrops(String searchType, String searchParam, ArrayList<RootCrop> list) {
        int index;
        Comparator<RootCrop> rootCropComparator;

        switch (searchType) {
            case "type":
                rootCropComparator = Comparator.comparing(RootCrop::getType);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(searchParam).weight(null).color(null).build(), rootCropComparator);
                break;
            case "weight":
                rootCropComparator = Comparator.comparingDouble(RootCrop::getWeight);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(null).weight(Double.parseDouble(searchParam)).color(null).build(), rootCropComparator);
                break;
            case "color":
                rootCropComparator = Comparator.comparing(RootCrop::getColor);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(null).weight(null).color(searchParam).build(), rootCropComparator);
                break;
            default:
                index = -1;
                break;
        }
        return index;
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

    public static <T> int searchResultIndex(String searchType, String searchParam, ArrayList<T> list) {
        SearchingContext<T> searchingContext = new SearchingContext<>(new BinarySearch<>());
        int index = searchingContext.performSearch(searchType, searchParam, list);

        if (index == -1) {
            return -1;
        }

        return index;
    }
}
