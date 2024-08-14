package menu;

public class Message {
    public static void chooseClassOption(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Объектами какого класса вы хотите заполнить массив?");
        System.out.println("1 - Машины");
        System.out.println("2 - Книги");
        System.out.println("3 - Корнеплоды (клевое название)");
        System.out.println("9 - Я люблю реализовывать STRATEGY через list.of");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }

    public static void shameOnYou(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Тьфу на тебя");
        System.out.println(dashLine);
    }

    public static void chooseFillArrOption(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Выберите способ заполнения исходного массива:");
        System.out.println("1 - Чтение из файла");
        System.out.println("2 - Случайным образом");
        System.out.println("3 - Ручками");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }

    public static void chooseYouWantSomeSearch(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Хочешь найти нужный тебе объект?");
        System.out.println("1 - Да");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }

    public static void writeSearchObject(String className, String sortBy, String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Введите значение параметра '" + sortBy.substring(0, 1).toUpperCase() + sortBy.substring(1) + "' из класса " + className + ".");
        System.out.println(dashLine);
    }

    public static void goodbye(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- До свидания!");
        System.out.println(dashLine);
    }

    public static void carMergeSortOptions(String dashLine) {
        System.out.println(dashLine);
        System.out.println("По какому полю хотите сортировать массив?");
        System.out.println("1 - Мощность");
        System.out.println("2 - Модель");
        System.out.println("3 - Год");
        System.out.println(dashLine);
    }

    public static void bookMergeSortOptions(String dashLine) {
        System.out.println(dashLine);
        System.out.println("По какому полю хотите сортировать массив?");
        System.out.println("1 - Автор");
        System.out.println("2 - Название");
        System.out.println("3 - Количество страниц");
        System.out.println(dashLine);
    }

    public static void rootCropMergeSortOptions(String dashLine) {
        System.out.println(dashLine);
        System.out.println("По какому полю хотите сортировать массив?");
        System.out.println("1 - Тип");
        System.out.println("2 - Вес");
        System.out.println("3 - Цвет");
        System.out.println(dashLine);
    }

    public static void chooseSortOption(String dashLine) {
        System.out.println(dashLine);
        System.out.println("Выберите сортировку:");
        System.out.println("1 - Обычная MergeSort");
        System.out.println("2 - Четная MergeSort");
        System.out.println("3 - Нечетная MergeSort");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }

    public static void chooseSortParamMergeSortEvenOdd(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Выберите поле, по которому будет четная сортировка:");
        System.out.println("1 - Мощность");
        System.out.println("2 - Год");
        System.out.println(dashLine);
    }

    public static void sortByEvenOrOddPages(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Cортировка по четным числам страниц:");
        System.out.println(dashLine);
    }

    public static void cantBeEvenOrOdd(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- К сожалению, дробные числа, такие, как вес, не могут быть четными или нечетными");
        System.out.println(dashLine);
    }

    public static void writeArrLength(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Введите количество элементов массива от 1 до 10:");
        System.out.println(dashLine);
    }

    public static void wrongArrLength(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Число должно располагаться в диапазоне от 1 до 10");
    }

    public static void wrongFormatNum(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Данная строка не подходит для числового формата.");
    }

    public static void emptyString(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Вы ввели пустую строку.");
    }

    public static void cantFindObject(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Объекта с этими данными в массиве нет");
    }

    public static <T> void searchResultWithIndex(int index, T searchResult, String dashLine) {
        System.out.println(dashLine);
        System.out.println("Index: " + index);
        System.out.println(searchResult);
    }
}
