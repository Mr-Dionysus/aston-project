import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car testCar = new Car.CarBuilder(100, "Audi", 2010).build();
        Car testCar2 = new Car.CarBuilder(500, "BMW", 2015).build();
        Car testCar3 = new Car.CarBuilder(100, "Mercedes", 2005).build();
        Car testCar4 = new Car.CarBuilder(100, "Mercedes", 2005).build();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(testCar);
        cars.add(testCar2);
        cars.add(testCar3);
        cars.add(testCar4);

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