import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car1 = new Car.CarBuilder(100, "Audi", 2010).build();
        Car car2 = new Car.CarBuilder(500, "BMW", 2015).build();
        Car car3 = new Car.CarBuilder(100, "Mercedes", 2005).build();
        Car car4 = new Car.CarBuilder(100, "Mercedes", 2005).build();

        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<RootCrop> rootCrops = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        outer:
        while (true) {
            String classObjects;
            while (true) {
                System.out.println("What class's objects do you want to use - Car, Book or RootCrop? Write 'stop' to stop.");
                classObjects = scanner.nextLine();
                if (classObjects.equals("stop")) {
                    break outer;
                } else if (classObjects.isEmpty() || (!classObjects.equals("Car") && !classObjects.equals("Book") && !classObjects.equals("RootCrop"))) {
                    System.out.println("You wrote empty String. Please, write class that you want - Car, Book or RootCrop. Write 'stop' to stop.");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.println("Write a length of an array. Write '0' to stop.");
                int arrLength = 0;

                try {
                    arrLength = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + e.getMessage() + ". Please, write 0 or a positive number.");
                    continue;
                }

                if (arrLength == 0) {
                    break outer;
                } else if (arrLength < 0) {
                    System.out.println("You wrote negative number. Please, write 0 or a positive number.");
                } else {
                    break;
                }
            }

            System.out.println("Do you want to add new data in array via file, by random, or via console? Write 'stop' to stop.");
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

                    if (searchArr[0].equals(searchString)) {
                        System.out.println("You wrote the information in wrong format. Please, try again.");
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