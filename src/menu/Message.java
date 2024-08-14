package menu;

public class Message {
    public static void dashLine() {
        System.out.println("-".repeat(50));
    }

    public static void chooseClassOption() {
        Message.dashLine();
        System.out.println("- Объектами какого класса вы хотите заполнить массив?");
        System.out.println("1 - Машины");
        System.out.println("2 - Книги");
        System.out.println("3 - Корнеплоды (клевое название)");
        System.out.println("9 - Я люблю реализовывать STRATEGY через list.of");
        System.out.println("0 - Выход");
        Message.dashLine();
    }

    public static void shameOnYou() {
        Message.dashLine();
        System.out.println("- Тьфу на тебя");
    }

    public static void chooseFillArrOption() {
        Message.dashLine();
        System.out.println("- Выберите способ заполнения исходного массива:");
        System.out.println("1 - Чтение из файла");
        System.out.println("2 - Случайным образом");
        System.out.println("3 - Ручками");
        System.out.println("0 - Выход");
        Message.dashLine();
    }

    public static void chooseYouWantSomeSearch() {
        Message.dashLine();
        System.out.println("- Хочешь найти нужный тебе объект?");
        System.out.println("1 - Да");
        System.out.println("0 - Выход");
        Message.dashLine();
    }

    public static void writeSearchObject(String className, String sortBy) {
        Message.dashLine();
        System.out.println("- Введите значение параметра '" + sortBy.substring(0, 1).toUpperCase() + sortBy.substring(1) + "' из класса " + className + ".");
        Message.dashLine();
    }

    public static void goodbye() {
        Message.dashLine();
        System.out.println("- До свидания!");
        Message.dashLine();
    }

    public static void carMergeSortOptions() {
        Message.dashLine();
        System.out.println("По какому полю хотите сортировать массив?");
        System.out.println("1 - Мощность");
        System.out.println("2 - Модель");
        System.out.println("3 - Год");
        System.out.println("0 - Выход");
        Message.dashLine();
    }

    public static void bookMergeSortOptions() {
        Message.dashLine();
        System.out.println("По какому полю хотите сортировать массив?");
        System.out.println("1 - Автор");
        System.out.println("2 - Название");
        System.out.println("3 - Количество страниц");
        System.out.println("0 - Выход");
        Message.dashLine();
    }

    public static void rootCropMergeSortOptions() {
        Message.dashLine();
        System.out.println("По какому полю хотите сортировать массив?");
        System.out.println("1 - Тип");
        System.out.println("2 - Вес");
        System.out.println("3 - Цвет");
        System.out.println("0 - Выход");
        Message.dashLine();
    }

    public static void chooseSortOption() {
        Message.dashLine();
        System.out.println("Выберите сортировку:");
        System.out.println("1 - Обычная MergeSort");
        System.out.println("2 - Четная MergeSort");
        System.out.println("3 - Нечетная MergeSort");
        System.out.println("0 - Выход");
        Message.dashLine();
    }

    public static void chooseSortParamMergeSortEvenOdd() {
        Message.dashLine();
        System.out.println("- Выберите поле, по которому будет четная сортировка:");
        System.out.println("1 - Мощность");
        System.out.println("2 - Год");
        Message.dashLine();
    }

    public static void sortByEvenOrOddPages() {
        Message.dashLine();
        System.out.println("- Cортировка по четным числам страниц:");
        Message.dashLine();
    }

    public static void cantBeEvenOrOdd() {
        Message.dashLine();
        System.out.println("- К сожалению, дробные числа, такие, как вес, не могут быть четными или нечетными");
        Message.dashLine();
    }

    public static void writeArrLength() {
        Message.dashLine();
        System.out.println("- Введите количество элементов массива от 1 до 10:");
        Message.dashLine();
    }

    public static void wrongArrLength() {
        Message.dashLine();
        System.out.println("- Число должно располагаться в диапазоне от 1 до 10");
        Message.dashLine();
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

    public static <T> void searchResultWithIndex(int index, T searchResult) {
        Message.dashLine();
        System.out.println("Index: " + index);
        System.out.println(searchResult);
    }

    public static void invalidCommand() {
        Message.dashLine();
        System.out.println("- Неверная команда");
    }

    public static void stopWordZero() {
        System.out.println("- Введите '0' если хотите остановиться.");
    }

    public static void stopWordStop() {
        System.out.println("- Введите 'stop' если хотите остановиться.");
    }

    public static void writeCarPower() {
        Message.dashLine();
        stopWordZero();
        System.out.print("- Введите количество лошадей, минимум - 66: ");
    }

    public static void writeCarModel() {
        Message.dashLine();
        stopWordZero();
        System.out.print("- Введите название машины: ");
    }

    public static void writeCarYear() {
        Message.dashLine();
        stopWordZero();
        System.out.print("- Введите год выпуска в промежутке 1886 - 2024: ");
    }

    public static void writeBookAuthor() {
        stopWordStop();
        System.out.print("- Введите автора книги: ");
    }

    public static void writeBookName() {
        stopWordZero();
        System.out.print("- Введите название книги: ");
    }

    public static void writeBookPages() {
        stopWordZero();
        System.out.print("- Введите количество страниц в книге от 1 до 1000: ");
    }

    public static void writeRootCropType() {
        stopWordStop();
        System.out.print("- Введите тип корнеплода: ");
    }

    public static void writeRootCropColor() {
        stopWordStop();
        System.out.print("- Введите цвет корнеплода: ");
    }

    public static void writeRootCropWeight() {
        stopWordZero();
        System.out.print("- Введите вес корнеплода: ");
    }

    public static void errTooMuchDots() {
        Message.dashLine();
        System.out.println("- Ты написал больше 1 возможной точки");
    }
}
