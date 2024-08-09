import java.util.ArrayList;

public class SearchingContext {
    private SearchingStrategy searchingStrategy;

    public SearchingContext(SearchingStrategy searchingStrategy) {
        this.searchingStrategy = searchingStrategy;
    }

    public void setSearchingStrategy(SearchingStrategy searchingStrategy) {
        this.searchingStrategy = searchingStrategy;
    }

    public void performSearch(String searchType, String searchParam, ArrayList list) {
        searchingStrategy.sort(searchType, searchParam, list);
    }
}
