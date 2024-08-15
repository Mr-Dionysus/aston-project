package menu;

public class Err {
    public static void cantBeEvenOrOdd() {
        Message.dashLine();
        System.out.println("- К сожалению, дробные числа, такие, как вес, не могут быть четными или нечетными");
        Message.dashLine();
    }

    public static void wrongArrLength() {
        Message.dashLine();
        System.out.println("- Число должно располагаться в диапазоне от 1 до 10");
    }

    public static void wrongFormatNum() {
        Message.dashLine();
        System.out.println("- Данная строка не подходит для числового формата.");
    }

    public static void emptyString() {
        Message.dashLine();
        System.out.println("- Вы ввели пустую строку.");
    }

    public static void cantFindObject() {
        Message.dashLine();
        System.out.println("- Объекта с этими данными в массиве нет");
    }

    public static void invalidCommand() {
        Message.dashLine();
        System.out.println("- Неверная команда");
    }

    public static void tooMuchDots() {
        Message.dashLine();
        System.out.println("- Ты написал больше 1 возможной точки");
    }
}
