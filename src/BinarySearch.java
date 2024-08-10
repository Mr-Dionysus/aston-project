import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearch<T> implements SearchingStrategy<T> {
    @Override
    public int search(String searchType, String searchParam, ArrayList<T> list) {
        if (list.isEmpty()) {
            return -1;
        }

        T example = list.getFirst();

        if (example instanceof Car) {
            return searchInCars(searchType, searchParam, (ArrayList<Car>) list);
        } else if (example instanceof Book) {
            return searchInBooks(searchType, searchParam, (ArrayList<Book>) list);
        } else if (example instanceof RootCrop) {
            return searchInRootCrops(searchType, searchParam, (ArrayList<RootCrop>) list);
        }
        return -1;
    }

    private int searchInCars(String searchType, String searchParam, ArrayList<Car> list) {
        int index = -1;
        Comparator<Car> carComparator;

        switch (searchType) {
            case "power":
                carComparator = Comparator.comparingInt(Car::getPower);
                index = indexedBinarySearch(list, new Car.CarBuilder(Integer.parseInt(searchParam), null, 0).build(), carComparator);
                break;
            case "model":
                carComparator = Comparator.comparing(Car::getModel);
                index = indexedBinarySearch(list, new Car.CarBuilder(0, searchParam, 0).build(), carComparator);
                break;
            case "year":
                carComparator = Comparator.comparingInt(Car::getYear);
                index = indexedBinarySearch(list, new Car.CarBuilder(0, null, Integer.parseInt(searchParam)).build(), carComparator);
                break;
        }
        return index;
    }

    private int searchInBooks(String searchType, String searchParam, ArrayList<Book> list) {
        int index = -1;
        Comparator<Book> bookComparator;

        switch (searchType) {
            case "author":
                bookComparator = Comparator.comparing(Book::getAuthor);
                index = indexedBinarySearch(list, new Book.BookBuilder(searchParam, null, 0).build(), bookComparator);
                break;
            case "name":
                bookComparator = Comparator.comparing(Book::getName);
                index = indexedBinarySearch(list, new Book.BookBuilder(null, searchParam, 0).build(), bookComparator);
                break;
            case "pages":
                bookComparator = Comparator.comparingInt(Book::getPages);
                index = indexedBinarySearch(list, new Book.BookBuilder(null, null, Integer.parseInt(searchParam)).build(), bookComparator);
                break;
        }
        return index;
    }

    private int searchInRootCrops(String searchType, String searchParam, ArrayList<RootCrop> list) {
        int index = -1;
        Comparator<RootCrop> rootCropComparator;
        switch (searchType) {
            case "type":
                rootCropComparator = Comparator.comparing(RootCrop::getType);
                index = indexedBinarySearch(list, new RootCrop.RootCropBuilder(searchParam, 0, null).build(), rootCropComparator);
                break;
            case "weight":
                rootCropComparator = Comparator.comparingDouble(RootCrop::getWeight);
                index = indexedBinarySearch(list, new RootCrop.RootCropBuilder(null, Double.parseDouble(searchParam), null).build(), rootCropComparator);
                break;
            case "color":
                rootCropComparator = Comparator.comparing(RootCrop::getColor);
                index = indexedBinarySearch(list, new RootCrop.RootCropBuilder(null, 0, searchParam).build(), rootCropComparator);
                break;
        }
        return index;
    }

    private static <T> int indexedBinarySearch(ArrayList<? extends T> list, T key, Comparator<? super T> comparator) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
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

    public static <T> void searchTryCatchIndexOutOfBoundsException(String searchType, String searchParam, ArrayList<T> list) {
        SearchingContext<T> searchingContext = new SearchingContext<>(new BinarySearch<>());

        int index = searchingContext.performSearch(searchType, searchParam, list);
       
        try {
            System.out.println(list.get(index) + "\n--------------");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
}
