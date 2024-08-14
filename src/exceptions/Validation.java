package exceptions;

import menu.Message;

public class Validation {
    public static int carPower(String input, String dashLine) {
        int power = Integer.parseInt(input);

        if (power >= 66) {
            return power;
        } else if (power < 66) {
            System.out.println(dashLine);
            System.out.println("- Вы ввели меньшее число, чем минимальное количество лошадей в машинах США - 66");
            return -1;
        } else {
            Message.invalidCommand(dashLine);
            return -1;
        }
    }

    public static int carYear(String input, String dashLine) {
        int year = Integer.parseInt(input);

        if (year >= 1886 && year <= 2024) {
            return year;
        } else if (year < 1886) {
            System.out.println(dashLine);
            System.out.println("- В этом году автомобилей еще не было");
            return -1;
        } else if (year > 2024) {
            System.out.println(dashLine);
            System.out.println("- Пока что мы не перешагнули за 2024 год");
            return -1;
        } else {
            Message.invalidCommand(dashLine);
            return -1;
        }
    }

    public static String removeSymbolsNums(String input) {
        input = input.replaceAll("[^\\w\\s]|\\d|_", "");
        System.out.println(input);
        return input;
    }

    public static String removeSymbols(String input) {
        input = input.replaceAll("[^\\w\\s]|_", "");
        System.out.println(input);
        return input;
    }

    public static String removeSymbolsLettersSpaces(String input) {
        input = input.replaceAll("[a-zA-Z]|[^\\w\\s\\d]|[ _]", "");
        System.out.println(input);
        return input;
    }

    public static String removeSymbolsWithoutDotLettersSpaces(String input) {
        input = input.replaceAll("[a-zA-Z]|[^\\w\\s\\d.]|[ _]", "");
        System.out.println(input);
        return input;
    }
}
