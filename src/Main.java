import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car testCar = new Car.CarBuilder(100, "Audi", 2010).build();
        Car testCar2 = new Car.CarBuilder(500, "BMW", 2015).build();
        Car testCar3 = new Car.CarBuilder(700, "Mercedes", 2005).build();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(testCar);
        cars.add(testCar2);
        cars.add(testCar3);

        BinarySearch binarySearch = new BinarySearch("power", "100", cars);
        BinarySearch binarySearch2 = new BinarySearch("model", "BMW", cars);
        BinarySearch binarySearch3 = new BinarySearch("year", "2015", cars);

        //int index = Collections.binarySearch(cars, new Car.CarBuilder(500, "", 0).build(), comparator);

        while (true) {
            System.out.println("What class's objects do you want to use? Write 'stop' to stop\n");
            String classObjects = scanner.nextLine();
            if (classObjects.equals("stop")) {
                break;
            }

            System.out.println("Write a length of array. Write '0' to stop\n");
            int arrLength = Integer.parseInt(scanner.nextLine());
            if (arrLength == 0) {
                break;
            }

            System.out.println("Do you want to add new data in array via file, by random, or via console? Write 'stop' to stop\n");
            String addDataOptions = scanner.nextLine();
            if (addDataOptions.equals("stop")) {
                break;
            }
        }
    }
}