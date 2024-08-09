import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MergeSort mergeSort = new MergeSort();

        Car testCar = new Car.CarBuilder(100, "Audi", 2010).build();
        Car testCar2 = new Car.CarBuilder(500, "BMW", 2015).build();
        Car testCar3 = new Car.CarBuilder(100, "Mercedes", 2005).build();
        Car testCar4 = new Car.CarBuilder(100, "Mercedes", 2005).build();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(testCar);
        cars.add(testCar2);
        cars.add(testCar3);
        cars.add(testCar4);

        System.out.println("До сортировки по мощнсоти: " + cars);
        mergeSort.mergeSort(cars, Comparator.comparingInt(Car::getPower));
        System.out.println("После сортировки по мощности: " + cars);

        System.out.println("До сортировки по названию: " + cars);
        mergeSort.mergeSort(cars, Comparator.comparing(Car::getModel));
        System.out.println("После сортировки по названию: " + cars);

        System.out.println("До сортировки по году: " + cars);
        mergeSort.mergeSort(cars, Comparator.comparingInt(Car::getYear));
        System.out.println("После сортировки по году: " + cars);

        while (true) {
            System.out.println("What class's objects do you want to use? Write 'stop' to stop");
            String classObjects = scanner.nextLine();
            if (classObjects.equals("stop")) {
                break;
            }

            System.out.println("Write a length of an array. Write '0' to stop");
            int arrLength = Integer.parseInt(scanner.nextLine());
            if (arrLength == 0) {
                break;
            }

            System.out.println("Do you want to add new data in array via file, by random, or via console? Write 'stop' to stop");
            String addDataOptions = scanner.nextLine();
            if (addDataOptions.equals("stop")) {
                break;
            }

            /*
            Console writing realization

            while (true) {

            }
            */

            while (true) {
                System.out.println("Do you want to find an object with specific information? Write Y or N.");
                String searchOption = scanner.nextLine();

                if (searchOption.equals("N")) {
                    break;
                } else if (searchOption.equals("Y")) {
                    System.out.println("Write specific information that you want to find with comma like that - 'power,100'. You have next options: Car (power, model, year), Book (author, name, pages), RootCrop (type, weight, color).");
                    String searchString = scanner.nextLine();
                    String[] searchArr = searchString.split(",");
                    String searchType = searchArr[0];
                    String searchParam = searchArr[1];

                    SearchingContext searchingContext = new SearchingContext(new BinarySearch());
                    int index = searchingContext.performSearch(searchType, searchParam, cars);

                    try {
                        System.out.println(cars.get(index) + "\n--------------");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage() + "\n");
                    }
                }
            }
        }
    }
}