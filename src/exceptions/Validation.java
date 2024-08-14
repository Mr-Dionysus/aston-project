package exceptions;

import menu.Message;

public class Validation {
    public static int carPower(String input) {
        if (input.isEmpty()) {
            Message.emptyString();
            return -1;
        } else if (input.equals("0")) {
            return 0;
        }

        int power = Integer.parseInt(input);

        if (power >= 66) {
            return power;
        } else if (power < 66) {
            Message.dashLine();
            System.out.println("- Вы ввели меньшее число, чем минимальное количество лошадей в машинах США - 66");
            return -1;
        } else {
            Message.invalidCommand();
            return -1;
        }
    }

    public static int carYear(String input) {
        if (input.isEmpty()) {
            return -1;
        } else if (input.equals("0")) {
            return 0;
        }

        int year = Integer.parseInt(input);

        if (year >= 1886 && year <= 2024) {
            return year;
        } else if (year < 1886) {
            Message.dashLine();
            System.out.println("- В этом году автомобилей еще не было");
            return -1;
        } else if (year > 2024) {
            Message.dashLine();
            System.out.println("- Пока что мы не перешагнули за 2024 год");
            return -1;
        } else {
            Message.invalidCommand();
            return -1;
        }
    }

    public static int bookPages(String input) {
        if (input.isEmpty()) {
            return -1;
        } else if (input.equals("0")) {
            return 0;
        }

        int pages = Integer.parseInt(input);

        if (pages >= 1 && pages <= 1000) {
            return pages;
        } else if (pages < 1) {
            Message.dashLine();
            System.out.println("- Еще не существует книг со страницами менее 1");
            return -1;
        } else if (pages > 1000) {
            Message.dashLine();
            System.out.println("- Мы еще не встречали книги со страницами более 1000");
            return -1;
        } else {
            Message.invalidCommand();
            return -1;
        }
    }

    public static double rootCropWeight(String input) {
        if (input.isEmpty()) {
            Message.emptyString();
            return -1;
        } else if (input.equals("0")) {
            return 0;
        }

        long dots = input.chars().filter(ch -> ch == '.').count();

        if (dots > 1) {
            Message.errTooMuchDots();
            return -1;
        }

        double weight = Double.parseDouble(input);

        if (weight > 0) {
            return weight;
        } else if (weight < 0) {
            Message.dashLine();
            System.out.println("- Пока еще мы не встречали корнеплодов с отсутствующим или отрицательным весом");
            return -1;
        } else {
            Message.invalidCommand();
            return -1;
        }
    }

    public static String removeSymbolsNums(String input) {
        input = input.replaceAll("[^\\w\\s]|\\d|_", "");
        return input;
    }

    public static String removeSymbols(String input) {
        input = input.replaceAll("[^\\w\\s]|_", "");
        return input;
    }

    public static String removeSymbolsLettersSpaces(String input) {
        input = input.replaceAll("[a-zA-Z]|[^\\w\\s\\d]|[ _]", "");
        return input;
    }

    public static String removeSymbolsWithoutDotLettersSpaces(String input) {
        input = input.replaceAll("[a-zA-Z]|[^\\w\\s\\d.]|[ _]", "");
        return input;
    }
}
