package sort;

import java.util.Comparator;
import java.util.List;

public class SortingContext<T> {
    private SortingStrategy<T> sortingStrategy;

    public SortingContext(SortingStrategy<T> sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy<T> sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(List<T> array, Comparator<? super T> comparator) {
        sortingStrategy.sort(array, comparator);
    }
}
