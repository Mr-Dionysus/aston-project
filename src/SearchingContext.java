import java.util.ArrayList;

public class SearchingContext<T> {
    private SearchingStrategy<T> searchingStrategy;

    public SearchingContext(SearchingStrategy<T> searchingStrategy) {
        this.searchingStrategy = searchingStrategy;
    }

    public void setSearchingStrategy(SearchingStrategy<T> searchingStrategy) {
        this.searchingStrategy = searchingStrategy;
    }

    public int performSearch(String searchType, String searchParam, ArrayList<T> list) {
        return searchingStrategy.search(searchType, searchParam, list);
    }
}
