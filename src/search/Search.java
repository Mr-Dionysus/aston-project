package search;

import menu.Message;
import validation.Validation;

import java.util.ArrayList;
import java.util.Scanner;

public class Search {
    // Выбирается подходящий поиск в зависимости от класса
    public static <C, B, R> void switchClassForSearch(Scanner scanner, String className, String sortBy, ArrayList<C> cars, ArrayList<B> books, ArrayList<R> rootCrops) {
        switch (className) {
            case "car":
                Search.youWantSomeSearch(scanner, className, cars, sortBy);
                break;
            case "book":
                Search.youWantSomeSearch(scanner, className, books, sortBy);
                break;
            case "rootcrop":
                Search.youWantSomeSearch(scanner, className, rootCrops, sortBy);
                break;
            default:
                Message.invalidCommand();
                break;
        }
    }

    // Выбор, хочет пользователь искать объект или нет
    public static <T> void youWantSomeSearch(Scanner scanner, String className, ArrayList<T> list, String sortBy) {
        String doSearch = Validation.removeSymbols(scanner.next());
        list.forEach(System.out::println);

        switch (doSearch) {
            case "1":
                // Ввести значение искомого параметра в зависимости от имеющихся: название класса и поле, по которому была сортировка
                Message.writeSearchObject(className, sortBy);
                Search.classOptionsForSearch(list, className, sortBy, scanner);
                break;
            case "0":
                break;
            default:
                Message.invalidCommand();
                break;
        }
    }

    // Поиск объекта с указанными ранее классом и параметром после указания значения параметра
    public static <T> T classOptionsForSearch(ArrayList<T> list, String className, String sortBy, Scanner scanner) {
        scanner.nextLine();
        String searchParam = scanner.nextLine().toLowerCase();

        if (searchParam.isEmpty()) {
            Message.emptyString();
            return null;
        }

        switch (className) {
            case "car", "book", "rootcrop":
                Search.searchResultObject(searchParam, sortBy, list);
                break;

            default:
                Message.invalidCommand();
                break;
        }
        return null;
    }

    // Поиск, который возвращает искомый объект или null
    public static <T> T searchResultObject(String searchParam, String sortBy, ArrayList<T> list) {
        SearchingContext<T> searchingContext = new SearchingContext<>(new BinarySearch<>());
        int index = searchingContext.performSearch(sortBy, searchParam, list);
        T searchResult;

        if (index < 0 || index > list.size()) {
            Message.cantFindObject();
            return null;
        } else {
            searchResult = list.get(index);
            Message.searchResultWithIndex(index, searchResult);
            return searchResult;
        }
    }
}
