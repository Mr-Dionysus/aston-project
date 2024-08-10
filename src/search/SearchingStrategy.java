package search;

import java.util.ArrayList;

public interface SearchingStrategy<T> {
    int search(String searchType, String searchParam, ArrayList<T> list);
}
