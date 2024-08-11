package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T> implements SortingStrategy<T> {
/*
    Сортировка до паттерна Strategy

    public <T> void mergeSort(List<T> array, Comparator<? super T> comparator) {
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
        mergeSort(left, comparator);
        // Сортируем правую часть массива
        mergeSort(right, comparator);
        //Соединяем части в один массив
        merge(array, left, right, comparator);
    }
*/

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