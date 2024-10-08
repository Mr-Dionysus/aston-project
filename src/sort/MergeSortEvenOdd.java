package sort;

import menu.Err;
import menu.Message;
import models.Book;
import models.Car;
import models.RootCrop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MergeSortEvenOdd<T> implements SortingStrategy<T> {
    //even - true чётная сортировка, false - нечётная, по умолчанию четная.
    private static boolean isEven = true;
    private static String sortType = "";

    public static boolean getEven() {
        return isEven;
    }

    public static void setEven(boolean isEven) {
        MergeSortEvenOdd.isEven = isEven;
    }

    public static String getSortType() {
        return sortType;
    }

    public static void setSortType(String sortType) {
        MergeSortEvenOdd.sortType = sortType;
    }

    @Override
    public void sort(List<T> array, Comparator<? super T> comparator) {
        sort(array, MergeSortEvenOdd.getSortType(), MergeSortEvenOdd.getEven());
    }

    public void sort(List<T> array, String type, boolean isEven) {
        if (array.size() <= 1) {
            return;
        }
        sortEvenOdd(array, type, isEven);
    }

    private void sortEvenOdd(List<T> array, String type, boolean isEven) {
        //Валидация листа
        T example = array.getFirst();
        switch (type) {
            case "Year":
            case "Power":
                if (example instanceof Car) {
                    sortCaseCar((List<Car>) array, type, isEven);
                }
                break;
            case "Pages":
                if (example instanceof Book) {
                    sortCaseBook((List<Book>) array, isEven);
                }
                break;
            case "Weight":
                if (example instanceof RootCrop) {
                    sortCaseRootCrop((List<RootCrop>) array, isEven);
                }
                break;
            //Поле сортировки по умолчанию.
            default:
                if (example instanceof Car) {
                    sortCaseCar((List<Car>) array, "Year", isEven);
                } else if (example instanceof Book) {
                    sortCaseBook((List<Book>) array, isEven);
                } else if (example instanceof RootCrop) {
                    sortCaseRootCrop((List<RootCrop>) array, isEven);
                } else {
                    System.out.println("Exception: Wrong sorting parameter");
                }
        }
    }

    private void sortCaseCar(List<Car> array, String type, boolean even) {
        //Делаем копию листа
        List<Car> stored = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            stored.add(array.get(i));
        }
        //Удаляем все чёт/нечёт из копии, сортируем копию, передаём копию на мерж с основным листом
        SortingContext sortingContext = new SortingContext<>(new MergeSort<>());
        switch (type) {
            case "Year":
                Comparator<Car> compareToYear = Comparator.comparingInt(Car::getYear);
                if (even)
                    stored.removeIf(i -> i.getYear() % 2 != 0);
                else
                    stored.removeIf(i -> i.getYear() % 2 == 0);
                sortingContext.performSort(stored, compareToYear);
                mergeCaseCar(stored, array, type, even);
                break;
            case "Power":
                Comparator<Car> compareToPower = Comparator.comparingInt(Car::getPower);
                if (even)
                    stored.removeIf(i -> i.getPower() % 2 != 0);
                else
                    stored.removeIf(i -> i.getPower() % 2 == 0);
                sortingContext.performSort(stored, compareToPower);
                mergeCaseCar(stored, array, type, even);
                break;
        }
    }

    private void sortCaseBook(List<Book> array, boolean even) {
        List<Book> stored = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            stored.add(array.get(i));
        }
        SortingContext sortingContext = new SortingContext<>(new MergeSort<>());

        Comparator<Book> compareTo = Comparator.comparingInt(Book::getPages);
        if (even)
            stored.removeIf(i -> i.getPages() % 2 != 0);
        else
            stored.removeIf(i -> i.getPages() % 2 == 0);
        sortingContext.performSort(stored, compareTo);
        mergeCaseBook(stored, array, even);
    }

    private void sortCaseRootCrop(List<RootCrop> array, boolean even) {
        List<RootCrop> stored = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            stored.add(array.get(i));
        }
        SortingContext sortingContext = new SortingContext<>(new MergeSort<>());

        Comparator<RootCrop> compareTo = Comparator.comparingDouble(RootCrop::getWeight);
        if (even)
            stored.removeIf(i -> i.getWeight() % 2 != 0);
        else
            stored.removeIf(i -> i.getWeight() % 2 == 0);
        sortingContext.performSort(stored, compareTo);
        mergeCaseRootCrop(stored, array, even);
    }

    private void mergeCaseCar(List<Car> stored, List<Car> array, String type, Boolean sortEven) {
        //Итерируем по оригиналу и заменяем прошлые значения чёт/нечёт на сортированые.
        int t = 0;
        switch (type) {
            case "Year":
                for (int m = 0; m < array.size(); m++) {
                    if ((array.get(m).getYear() % 2) != 0 ^ sortEven) {
                        array.set(m, stored.get(t));
                        t++;
                    }
                }
                break;
            case "Power":
                for (int m = 0; m < array.size(); m++) {
                    if ((array.get(m).getPower() % 2) != 0 ^ sortEven) {
                        array.set(m, stored.get(t));
                        t++;
                    }
                }
                break;
            default:
        }
    }

    private void mergeCaseBook(List<Book> stored, List<Book> array, Boolean sortEven) {
        int t = 0;
        for (int m = 0; m < array.size(); m++) {
            if ((array.get(m).getPages() % 2) != 0 ^ sortEven) {
                array.set(m, stored.get(t));
                t++;
            }
        }
    }

    private void mergeCaseRootCrop(List<RootCrop> stored, List<RootCrop> array, Boolean sortEven) {
        int t = 0;
        for (int m = 0; m < array.size(); m++) {
            if ((array.get(m).getWeight() % 2) != 0 ^ sortEven) {
                array.set(m, stored.get(t));
                t++;
            }
        }
    }

    // Проверка класса, после которой идет либо опросник, если больше 1 числового поля, либо сразу сортировка
    public static void mergeSortedArrEvenOdd(String className, Scanner scanner, SortingContext sortingContext, ArrayList cars, ArrayList books) {
        sortingContext.setSortingStrategy(new MergeSortEvenOdd());

        switch (className) {
            // Выбор между сортировкой у Car по power или year
            case "car":
                Message.chooseSortParamMergeSortEvenOdd();
                switchSortParamsMergeSort(cars, scanner, sortingContext);
                break;
            // Сортировка по страницам
            case "book":
                Message.sortByEvenOrOddPages();
                Comparator<Book> bookComparator = Comparator.comparingInt(Book::getPages);
                sortingContext.performSort(books, bookComparator);
                Message.dashLine();
                books.forEach(System.out::println);
                break;

            case "rootcrop":
                Err.cantBeEvenOrOdd();
                break;

            default:
                Err.invalidCommand();
                break;
        }
    }

    // Выбор между сортировкой у Car по power или year
    public static <T> String switchSortParamsMergeSort(ArrayList<T> cars, Scanner scanner, SortingContext sortingContext) {
        String input = scanner.next().replaceAll("[^\\w\\s]|_", "");
        Comparator carComparator;

        switch (input) {
            case "1":
                MergeSortEvenOdd.setSortType("Power");
                carComparator = Comparator.comparingInt(Car::getPower);
                break;
            case "2":
                MergeSortEvenOdd.setSortType("Year");
                carComparator = Comparator.comparingInt(Car::getYear);
                break;
            case "0":
                return input;
            default:
                Err.invalidCommand();
                input = "0";
                return input;
        }
        // Запуск сортировки
        sortingContext.performSort(cars, carComparator);
        Message.dashLine();
        cars.forEach(System.out::println);
        return input;
    }
}
