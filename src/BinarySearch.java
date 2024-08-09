import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearch implements SearchingStrategy {
    @Override
    public int search(String searchType, String searchParam, ArrayList list) {
        int index = 0;
        Comparator<Car> carComparator;
        Comparator<Book> bookComparator;
        Comparator<RootCrop> rootCropComparator;

        switch (searchType) {
            // Searching the Car
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
            // Searching the Book
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
            // Searching the RootCrop
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


    private static <T> int indexedBinarySearch(List<? extends T> list, T key, Comparator<? super T> comparator) {
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
}
