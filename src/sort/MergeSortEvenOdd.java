package sort;

import models.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSortEvenOdd<T> {

    public void sortEven(List<T> array, Comparator<? super T> comparator) {
        if (array.size() <= 1) {
            return;
        }

        if (array.getFirst() instanceof Car) {
            sortCar((List<Car>) array, (Comparator<Car>) comparator);
        }
//        else if (example instanceof Book) {
//            return searchInBooks(searchType, searchParam, (ArrayList<Book>) list);
//        } else if (example instanceof RootCrop) {
//            return searchInRootCrops(searchType, searchParam, (ArrayList<RootCrop>) list);
//        }
    }

    private static void sortCar(List<Car> array, Comparator<Car> comparator) {
        sortCar(array, comparator, true);
    }

    private static void sortCar(List<Car> array, Comparator<Car> comparator, boolean even) {
        List<Car> stored = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            stored.add(array.get(i));
        }
        if (even) stored.removeIf(i -> i.getYear() % 2 != 0);
        else stored.removeIf(i -> i.getYear() % 2 == 0);
        mergeSort(stored, comparator);
        mergeCar(stored, array, even);
    }

    private static void mergeCar(List<Car> stored, List<Car> array, Boolean sortEven) {
        int t = 0;
        for (int m = 0; m < array.size(); m++) {
            if ((array.get(m).getYear() % 2) != 0 ^ sortEven) {
                array.set(m, stored.get(t));
                t++;
            }
        }
    }

    public static <T> void merge(List<T> L1, List<T> L2, List<T> L, Comparator<T> C) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < L1.size() && j < L2.size()) {
            if (C.compare(L1.get(i), L2.get(j)) < 0) {
                L.set(k++, L1.get(i++));
            } else {
                L.set(k++, L2.get(j++));
            }
        }
        while (i < L1.size()) {
            L.set(k++, L1.get(i++));
        }
        while (j < L2.size()) {
            L.set(k++, L2.get(j++));
        }
    }

    public static <T> void mergeSort(List<T> L, Comparator<T> C) {
        int size = L.size();
        if (size < 2) {
            return;
        }
        int half = size / 2;
        List<T> L1 = new ArrayList<T>(L.subList(0, half));
        List<T> L2 = new ArrayList<T>(L.subList(half, size));

        mergeSort(L1, C);
        mergeSort(L2, C);

        merge(L1, L2, L, C);
    }

}
