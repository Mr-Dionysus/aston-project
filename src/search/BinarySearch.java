package search;

import menu.Err;
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
        // Выбор метода в зависимости от класса первого объекта в листе
        if (example instanceof Car) {
            return searchInCars(searchType, searchParam, (ArrayList<Car>) list);
        } else if (example instanceof Book) {
            return searchInBooks(searchType, searchParam, (ArrayList<Book>) list);
        } else if (example instanceof RootCrop) {
            return searchInRootCrops(searchType, searchParam, (ArrayList<RootCrop>) list);
        }
        return -1;
    }

    // Поиск в машинах в зависимости от имеющегося типа параметра
    private int searchInCars(String searchType, String searchParam, ArrayList<Car> list) {
        int index;
        Comparator<Car> carComparator;

        switch (searchType) {
            case "power":
                try {
                    Integer.parseInt(searchParam);
                } catch (NumberFormatException e) {
                    Err.wrongFormatNum();
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
                    Err.wrongFormatNum();
                    return -1;
                }

                carComparator = Comparator.comparingInt(Car::getYear);
                index = indexedBinarySearch(list, new Car.Builder().power(0).model(null).year(Integer.parseInt(searchParam)).build(), carComparator);
                return index;
            default:
                return -1;
        }
    }

    // Поиск в книгах в зависимости от имеющегося типа параметра
    private int searchInBooks(String searchType, String searchParam, ArrayList<Book> list) {
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
                    Err.wrongFormatNum();
                    return -1;
                }

                bookComparator = Comparator.comparingInt(Book::getPages);
                index = indexedBinarySearch(list, new Book.Builder().author(null).name(null).pages(Integer.parseInt(searchParam)).build(), bookComparator);
                return index;
            default:
                return -1;
        }
    }

    // Поиск в корнеплодах в зависимости от имеющегося типа параметра
    private int searchInRootCrops(String searchType, String searchParam, ArrayList<RootCrop> list) {
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
                    Err.wrongFormatNum();
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
        // Берется первый и последний индексы
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            // Более быстрое деление на 2 (сдвиг битов вправо)
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            // Сравнивается midVal (средний объект в листе) и key (переданный объект с дефолтными значениями параметров и одним искомым значением параметра) через переданный компаратор
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
