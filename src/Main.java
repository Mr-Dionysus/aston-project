import menu.MainMenu;
import models.Book;
import models.Car;
import models.RootCrop;
import sort.MergeSort;
import sort.MergeSortEvenOdd;
import sort.SortingContext;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Car> cars = new ArrayList<>();
//        ArrayList<Book> books = new ArrayList<>();
//        ArrayList<RootCrop> rootCrops = new ArrayList<>();
//        ArrayList<Car> carsByYear = new ArrayList<>();
//
//        Car car1 = new Car.Builder().power(100).model("Audi").year(2020).build();
//        Car car2 = new Car.Builder().power(500).model("BMW").year(2015).build();
//        Car car3 = new Car.Builder().power(100).model("Mercedes").year(2005).build();
//        Car car4 = new Car.Builder().power(100).model("Mercedes").year(2005).build();
//
//        cars.add(car1);
//        cars.add(car2);
//        cars.add(car3);
//        cars.add(car4);
//
//        carsByYear.add(car1);
//        carsByYear.add(car2);
//        carsByYear.add(car3);
//        carsByYear.add(car4);
//
//        Comparator<Car> carComparator;
//        carComparator = Comparator.comparingInt(Car::getPower);
//
//        SortingContext oddEven = new SortingContext<>(new MergeSortEvenOdd());
//
//        System.out.print("...........");
//        System.out.println(carsByYear);
//        System.out.print("...........");
//        oddEven.performSort(carsByYear, carComparator);
//        System.out.println(carsByYear);
//        System.out.print("...........");
//
//
//        RootCrop rootCrop = new RootCrop.Builder().type("test").weight(0.0).color("test").build();
//        RootCrop rootCrop2 = new RootCrop.Builder().type("test").weight(0.0).color("test").build();
//
//        rootCrops.add(rootCrop);
//        rootCrops.add(rootCrop2);
//
//        SortingContext sortingContext = new SortingContext<>(new MergeSort<>());
//
//        System.out.println("До сортировки по мощности: " + cars);
//        sortingContext.performSort(cars, Comparator.comparingInt(Car::getPower));
//        System.out.println("После сортировки по мощности: " + cars);
//
//        System.out.println("До сортировки по названию: " + cars);
//        sortingContext.performSort(cars, Comparator.comparing(Car::getModel));
//        System.out.println("После сортировки по названию: " + cars);
//
//        System.out.println("До сортировки по году: " + cars);
//        sortingContext.performSort(cars, Comparator.comparingInt(Car::getYear));
//        System.out.println("После сортировки по году: " + cars);

        MainMenu mainMenu = new MainMenu();
        mainMenu.start();
    }
}

