package search;

import menu.Message;

import java.util.ArrayList;
import java.util.Scanner;

public class Search {
    public static <C, B, R> void switchClassForSearch(Scanner scanner, String className, String sortBy, ArrayList<C> cars, ArrayList<B> books, ArrayList<R> rootCrops, String dashLine) {
        switch (className) {
            case "car":
                Search.youWantSomeSearch(scanner, className, cars, sortBy, dashLine);
                break;
            case "book":
                Search.youWantSomeSearch(scanner, className, books, sortBy, dashLine);
                break;
            case "rootcrop":
                Search.youWantSomeSearch(scanner, className, rootCrops, sortBy, dashLine);
                break;
            default:
                Message.invalidCommand(dashLine);
                break;
        }
    }

    public static <T> void youWantSomeSearch(Scanner scanner, String className, ArrayList<T> list, String sortBy, String dashLine) {
        String doSearch = scanner.next().replaceAll("[^\\w\\s]|_", "");
        list.forEach(System.out::println);

        switch (doSearch) {
            case "1":
                Message.writeSearchObject(className, sortBy, dashLine);
                Search.classOptionsForSearch(list, className, sortBy, scanner, dashLine);
                break;
            case "0":
                break;
            default:
                Message.invalidCommand(dashLine);
                break;
        }
    }

    public static <T> T classOptionsForSearch(ArrayList<T> list, String className, String sortBy, Scanner scanner, String dashLine) {
        scanner.nextLine();
        String searchParam = scanner.nextLine().toLowerCase();

        if (searchParam.isEmpty()) {
            Message.emptyString(dashLine);
            return null;
        }

        switch (className) {
            case "car", "book", "rootcrop":
                Search.searchResultObject(searchParam, sortBy, list, dashLine);
                break;

            default:
                Message.invalidCommand(dashLine);
                break;
        }
        return null;
    }

    public static <T> T searchResultObject(String searchParam, String sortBy, ArrayList<T> list, String dashLine) {
        SearchingContext<T> searchingContext = new SearchingContext<>(new BinarySearch<>());
        int index = searchingContext.performSearch(sortBy, searchParam, list, dashLine);
        T searchResult;

        if (index < 0 || index > list.size()) {
            Message.cantFindObject(dashLine);
            return null;
        } else {
            searchResult = list.get(index);
            Message.searchResultWithIndex(index, searchResult, dashLine);
            return searchResult;
        }
    }
}
