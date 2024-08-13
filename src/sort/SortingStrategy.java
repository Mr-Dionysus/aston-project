package sort;

import java.util.Comparator;
import java.util.List;

public interface SortingStrategy<T> {
    void sort(List<T> array, Comparator<? super T> comparator);
}
