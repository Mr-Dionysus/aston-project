package sort;

import menu.Message;
import models.Book;
import models.Car;
import models.RootCrop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MergeSort<T> implements SortingStrategy<T> {
    // Метод для слияние двух отсортированных частей (левой и правой)
    private <T> void merge(List<T> array, List<T> left, List<T> right, Comparator<? super T> comparator) {
		/* i — текущий индекс в левом массиве left
		   j — текущий индекс в правом массиве right
		   k — текущий индекс в исходном массиве array */
        int i = 0, j = 0, k = 0;

        // Сравниваем элементы из обеих частей и добавляем в исходный массив на свои места
        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                array.set(k++, left.get(i++));
            } else {
                array.set(k++, right.get(j++));
            }
        }

        // Добавляем оставшиеся элементы из левой части (если они есть)
        while (i < left.size()) {
            array.set(k++, left.get(i++));
        }

        // Добавляем оставшиеся элементы из правой части (если они есть)
        while (j < right.size()) {
            array.set(k++, right.get(j++));
        }
    }

    public static String mergeSortArr(String className, Scanner scanner, SortingContext sortingContext, ArrayList cars, ArrayList books, ArrayList rootCrops, String messageInvalidCommand, String dashLine) {
        Comparator<Car> carComparator;
        Comparator<Book> bookComparator;
        Comparator<RootCrop> rootCropComparator;

        switch (className) {
            case "car":
                Message.carMergeSortOptions(dashLine);

                String input = scanner.next();

                switch (input) {
                    case "1":
                        sortingContext.setSortingStrategy(new MergeSort());
                        carComparator = Comparator.comparingInt(Car::getPower);
                        sortingContext.performSort(cars, carComparator);

                        System.out.println(dashLine);
                        cars.forEach(System.out::println);
                        input = "power";
                        break;
                    case "2":
                        sortingContext.setSortingStrategy(new MergeSort());
                        carComparator = Comparator.comparing(Car::getModel);
                        sortingContext.performSort(cars, carComparator);

                        System.out.println(dashLine);
                        cars.forEach(System.out::println);
                        input = "model";
                        break;
                    case "3":
                        sortingContext.setSortingStrategy(new MergeSort());
                        carComparator = Comparator.comparingInt(Car::getYear);
                        sortingContext.performSort(cars, carComparator);

                        System.out.println(dashLine);
                        cars.forEach(System.out::println);
                        input = "year";
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println(dashLine);
                        System.out.println(messageInvalidCommand);
                        break;
                }

                return input;

            case "book":
                Message.bookMergeSortOptions(dashLine);

                input = scanner.next();

                switch (input) {
                    case "1":
                        sortingContext.setSortingStrategy(new MergeSort());
                        bookComparator = Comparator.comparing(Book::getAuthor);
                        sortingContext.performSort(books, bookComparator);

                        System.out.println(dashLine);
                        books.forEach(System.out::println);
                        input = "author";
                        break;
                    case "2":
                        sortingContext.setSortingStrategy(new MergeSort());
                        bookComparator = Comparator.comparing(Book::getName);
                        sortingContext.performSort(books, bookComparator);

                        System.out.println(dashLine);
                        books.forEach(System.out::println);
                        input = "name";
                        break;
                    case "3":
                        sortingContext.setSortingStrategy(new MergeSort());
                        bookComparator = Comparator.comparingInt(Book::getPages);
                        sortingContext.performSort(books, bookComparator);

                        System.out.println(dashLine);
                        books.forEach(System.out::println);
                        input = "pages";
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println(dashLine);
                        System.out.println(messageInvalidCommand);
                        break;
                }

                return input;

            case "rootcrop":
                Message.rootCropMergeSortOptions(dashLine);

                input = scanner.next();

                switch (input) {
                    case "1":
                        sortingContext.setSortingStrategy(new MergeSort());
                        rootCropComparator = Comparator.comparing(RootCrop::getType);
                        sortingContext.performSort(rootCrops, rootCropComparator);

                        System.out.println(dashLine);
                        rootCrops.forEach(System.out::println);
                        input = "type";
                        break;
                    case "2":
                        sortingContext.setSortingStrategy(new MergeSort());
                        rootCropComparator = Comparator.comparingDouble(RootCrop::getWeight);
                        sortingContext.performSort(rootCrops, rootCropComparator);

                        System.out.println(dashLine);
                        rootCrops.forEach(System.out::println);
                        input = "weight";
                        break;
                    case "3":
                        sortingContext.setSortingStrategy(new MergeSort());
                        rootCropComparator = Comparator.comparing(RootCrop::getColor);
                        sortingContext.performSort(rootCrops, rootCropComparator);

                        System.out.println(dashLine);
                        rootCrops.forEach(System.out::println);
                        input = "color";
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println(dashLine);
                        System.out.println(messageInvalidCommand);
                        break;
                }

                return input;

            default:
                System.out.println(messageInvalidCommand);
                break;
        }

        return "0";
    }

    public static String mergeSortEvenOddArr(String className, Scanner scanner, SortingContext sortingContext, ArrayList cars, ArrayList books, String messageInvalidCommand, String dashLine) {
        Comparator<Car> carComparator;
        Comparator<Book> bookComparator;

        switch (className) {
            case "car":
                System.out.println(dashLine);
                System.out.println("- Выберите поле, по которому будет четная сортировка:");
                System.out.println("1 - Мощность");
                System.out.println("2 - Год");
                System.out.println(dashLine);

                String input = scanner.next();

                switch (input) {
                    case "1":
                        sortingContext.setSortingStrategy(new MergeSortEvenOdd());
                        carComparator = Comparator.comparingInt(Car::getPower);
                        sortingContext.performSort(cars, carComparator);

                        System.out.println(dashLine);
                        cars.forEach(System.out::println);
                        break;
                    case "2":
                        sortingContext.setSortingStrategy(new MergeSortEvenOdd());
                        carComparator = Comparator.comparingInt(Car::getYear);
                        sortingContext.performSort(cars, carComparator);

                        System.out.println(dashLine);
                        cars.forEach(System.out::println);
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println(dashLine);
                        System.out.println(messageInvalidCommand);
                        break;
                }
                break;

            case "book":
                System.out.println(dashLine);
                System.out.println("- Cортировка по четным числам страниц:");
                System.out.println(dashLine);

                sortingContext.setSortingStrategy(new MergeSortEvenOdd());
                bookComparator = Comparator.comparingInt(Book::getPages);
                sortingContext.performSort(books, bookComparator);

                System.out.println(dashLine);
                books.forEach(System.out::println);
                break;

            case "rootcrop":
                System.out.println(dashLine);
                System.out.println("- К сожалению, дробные числа, такие, как вес, не могут быть четными или нечетными");
                System.out.println(dashLine);
                break;
            default:
                System.out.println(messageInvalidCommand);
                break;
        }

        return "0";
    }

    @Override
    public void sort(List<T> array, Comparator<? super T> comparator) {
        // Проверка на минимальное количество элементов в массиве (min 2)
        if (array.size() <= 1) {
            return;
        }

        // Находим середину массива
        int middle = array.size() / 2;
        // Выделяем левую часть массива от 0 до середины
        List<T> left = new ArrayList<>(array.subList(0, middle));
        // Выделяем правую часть массива от середины до конца
        List<T> right = new ArrayList<>(array.subList(middle, array.size()));

        // Сортируем левую часть массива
        sort(left, comparator);
        // Сортируем правую часть массива
        sort(right, comparator);
        //Соединяем части в один массив
        merge(array, left, right, comparator);
    }
}