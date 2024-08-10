import model.Book;
import model.Car;
import model.RootCrop;
import search.BinarySearch;
import sort.MergeSort;
import sort.SortingContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MergeSort mergeSort = new MergeSort();

        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<RootCrop> rootCrops = new ArrayList<>();

        Car car1 = new Car.Builder().power(100).model("Audi").year(2010).build();
        Car car2 = new Car.Builder().power(500).model("BMW").year(2015).build();
        Car car3 = new Car.Builder().power(100).model("Mercedes").year(2005).build();
        Car car4 = new Car.Builder().power(100).model("Mercedes").year(2005).build();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        RootCrop rootCrop = new RootCrop.Builder().type("test").weight(0.0).color("test").build();
        RootCrop rootCrop2 = new RootCrop.Builder().type("test").weight(0.0).color("test").build();

        rootCrops.add(rootCrop);
        rootCrops.add(rootCrop2);

        SortingContext sortingContext = new SortingContext<>(new MergeSort<>());

        System.out.println("До сортировки по мощности: " + cars);
        sortingContext.performSort(cars, Comparator.comparingInt(Car::getPower));
        System.out.println("После сортировки по мощности: " + cars);


        System.out.println("До сортировки по названию: " + cars);
        sortingContext.performSort(cars, Comparator.comparing(Car::getModel));
        System.out.println("После сортировки по названию: " + cars);

        System.out.println("До сортировки по году: " + cars);
        sortingContext.performSort(cars, Comparator.comparingInt(Car::getYear));
        System.out.println("После сортировки по году: " + cars);

        stopProgram:
        while (true) {
            while (true) {
                System.out.println("""
                        --------------
                        What class's objects do you want to use - 'car', 'book' or 'rootcrop'? Write 'stop' to stop.
                        --------------""");
                String classObjects = scanner.nextLine().toLowerCase();

                if (classObjects.equals("stop")) {
                    break stopProgram;
                } else if (classObjects.isEmpty() || (!classObjects.equals("car") && !classObjects.equals("book") && !classObjects.equals("rootcrop"))) {
                    System.out.println("""
                            --------------
                            You wrote empty String. Please, write class that you want - 'car', 'book' or 'rootcrop'. Write 'stop' to stop.""");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.println("""
                        --------------
                        Write a length of an array. Write '0' to stop.
                        --------------""");
                int arrLength;

                try {
                    arrLength = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("--------------\n" + "Error: " + e.getMessage() + ". Please, write '0' or a positive number.");
                    continue;
                }

                if (arrLength == 0) {
                    break stopProgram;
                } else if (arrLength < 0) {
                    System.out.println("""
                            --------------
                            You wrote negative number. Please, write '0' or a positive number.""");
                } else {
                    break;
                }
            }

            System.out.println("""
                    --------------
                    Do you want to add new data in array via 'file', by 'random', or via 'console'? Write 'stop' to stop.
                    --------------""");
            String addDataOptions = scanner.nextLine().toLowerCase();

            switch (addDataOptions) {
                case "stop":
                    break stopProgram;
                case "file":
                    //code realization
                    break;
                case "random":
                    //code realization
                    break;
                case "console":
                    //code realization
                    break;
            }

            /*
            Console writing realization

            while (true) {

            }
            */

            while (true) {
                System.out.println("""
                        --------------
                        Do you want to find an object with specific information? Write 'y' or 'n'.
                        --------------""");
                String doSearch = scanner.nextLine().toLowerCase();

                if (doSearch.equals("n")) {
                    break;
                } else if (doSearch.equals("y")) {
                    System.out.println("""
                            --------------
                            Write specific information that you want to find with comma like that - 'power,100'.
                            You have next options: Car ('power', 'model', 'year'), Book ('author', 'name', 'pages'), RootCrop ('type', 'weight' (Format: 0 or 0.0), 'color').
                            --------------""");
                    String searchString = scanner.nextLine().toLowerCase();
                    String[] searchArr = searchString.split(",");

                    String searchType = searchArr[0];

                    if (searchArr[0].equals(searchString)) {
                        System.out.println("""
                                --------------
                                You wrote the information in wrong format. Please, try again.""");
                        continue;
                    }

                    String searchParam = searchArr[1];

                    switch (searchType) {
                        case "power", "model", "year" -> {
                            BinarySearch.searchTryCatchIndexOutOfBoundsException(searchType, searchParam, cars);
                        }

                        case "author", "name", "pages" -> {
                            BinarySearch.searchTryCatchIndexOutOfBoundsException(searchType, searchParam, books);
                        }

                        case "type", "weight", "color" -> {
                            BinarySearch.searchTryCatchIndexOutOfBoundsException(searchType, searchParam, rootCrops);
                        }
                    }
                }
            }
        }
    }
}