import models.Car;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car car = null;
        List<Car> carList = car.ReadFile();
        carList.forEach(System.out::println);

//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("What class's objects do you want to use? Write 'stop' to stop");
//            String classObjects = scanner.nextLine();
//            if (classObjects.equals("stop")) {
//                break;
//            }
//
//            System.out.println("Write a length of array. Write '0' to stop");
//            int arrLength = Integer.parseInt(scanner.nextLine());
//            if (arrLength == 0) {
//                break;
//            }
//
//            System.out.println("Do you want to add new data in array via file, by random, or via console? Write 'stop' to stop");
//            String addDataOptions = scanner.nextLine();
//            if (addDataOptions == "stop") {
//                break;
//            }
//        }
    }
}