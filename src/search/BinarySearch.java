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

        T example = list.get(0);

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
                return indexFoundOrNotFoundElement(index, list);
            case "models":
                carComparator = Comparator.comparing(Car::getModel);
                index = indexedBinarySearch(list, new Car.Builder().power(0).model(searchParam).year(0).build(), carComparator);
                return indexFoundOrNotFoundElement(index, list);
            case "year":
                carComparator = Comparator.comparingInt(Car::getYear);
                index = indexedBinarySearch(list, new Car.Builder().power(0).model(null).year(Integer.parseInt(searchParam)).build(), carComparator);
                return indexFoundOrNotFoundElement(index, list);
            default:
                return -1;
        }
    }

    private int searchInBooks(String searchType, String searchParam, ArrayList<Book> list) {
        int index;
        Comparator<Book> bookComparator;

        switch (searchType) {
            case "author":
                bookComparator = Comparator.comparing(Book::getAuthor);
                index = indexedBinarySearch(list, new Book.Builder().author(searchParam).name(null).pages(0).build(), bookComparator);
                return indexFoundOrNotFoundElement(index, list);
            case "name":
                bookComparator = Comparator.comparing(Book::getName);
                index = indexedBinarySearch(list, new Book.Builder().author(null).name(searchParam).pages(0).build(), bookComparator);
                return indexFoundOrNotFoundElement(index, list);
            case "pages":
                bookComparator = Comparator.comparingInt(Book::getPages);
                index = indexedBinarySearch(list, new Book.Builder().author(null).name(null).pages(Integer.parseInt(searchParam)).build(), bookComparator);
                return indexFoundOrNotFoundElement(index, list);
            default:
                return -1;
        }
    }

    private int searchInRootCrops(String searchType, String searchParam, ArrayList<RootCrop> list) {
        int index;
        Comparator<RootCrop> rootCropComparator;

        switch (searchType) {
            case "type":
                rootCropComparator = Comparator.comparing(RootCrop::getType);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(searchParam).weight(null).color(null).build(), rootCropComparator);
                return indexFoundOrNotFoundElement(index, list);
            case "weight":
                rootCropComparator = Comparator.comparingDouble(RootCrop::getWeight);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(null).weight(Double.parseDouble(searchParam)).color(null).build(), rootCropComparator);
                return indexFoundOrNotFoundElement(index, list);
            case "color":
                rootCropComparator = Comparator.comparing(RootCrop::getColor);
                index = indexedBinarySearch(list, new RootCrop.Builder().type(null).weight(null).color(searchParam).build(), rootCropComparator);
                return indexFoundOrNotFoundElement(index, list);
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

    public static <T> T searchResultObject(String searchClass, String searchType, String searchParam, String messageInvalidCommand, String dashLine, ArrayList<T> list) {
        int index;
        T searchResult;
        String messageInvalidSearchType = messageInvalidCommand + "Ты написал тип " + searchType + ", которого нет у класса " + searchClass + ".";
        String messageCantFindElement = dashLine + "\nОбъекта с этими данными в массиве нет";

        switch (searchClass) {
            case "car":
                if (searchType.equals("power") || searchType.equals("model") || searchType.equals("year")) {
                    index = BinarySearch.searchResultIndex(searchType, searchParam, list);

                    if (index == -1) {
                        System.out.println(dashLine);
                        System.out.println(messageCantFindElement);
                    } else {
                        searchResult = list.get(index);

                        System.out.println(dashLine);
                        System.out.println("Index: " + index);
                        System.out.println(searchResult);

                        return searchResult;
                    }
                } else {
                    System.out.println(dashLine);
                    System.out.println(messageInvalidSearchType);
                }
                break;

            case "book":
                if (searchType.equals("author") || searchType.equals("name") || searchType.equals("pages")) {
                    index = BinarySearch.searchResultIndex(searchType, searchParam, list);

                    if (index == -1) {
                        System.out.println(dashLine);
                        System.out.println(messageCantFindElement);
                    } else {
                        searchResult = list.get(index);

                        System.out.println(dashLine);
                        System.out.println("Index: " + index);
                        System.out.println(searchResult);
                    }
                } else {
                    System.out.println(dashLine);
                    System.out.println(messageInvalidSearchType);
                }
                break;

            case "rootcrop":
                if (searchType.equals("type") || searchType.equals("weight") || searchType.equals("color")) {
                    index = BinarySearch.searchResultIndex(searchType, searchParam, list);

                    if (index == -1) {
                        System.out.println(dashLine);
                        System.out.println(messageCantFindElement);
                    } else {
                        searchResult = list.get(index);

                        System.out.println(dashLine);
                        System.out.println("Index: " + index);
                        System.out.println(searchResult);

                        return searchResult;
                    }
                } else {
                    System.out.println(dashLine);
                    System.out.println(messageInvalidSearchType);
                }
                break;
            default:
                System.out.println(dashLine);
                System.out.println(messageInvalidCommand);
                break;
        }

        return null;
    }

    public static <T> int searchResultIndex(String searchType, String searchParam, ArrayList<T> list) {
        SearchingContext<T> searchingContext = new SearchingContext<>(new BinarySearch<>());
        int index = searchingContext.performSearch(searchType, searchParam, list);

        if (index == -1) {
            return -1;
        }

        return index;
    }

    public static <T> int indexFoundOrNotFoundElement(int index, ArrayList<T> list) {
        if (index < 0 || index > list.size()) {
            return -1;
        } else {
            return index;
        }
    }
}
