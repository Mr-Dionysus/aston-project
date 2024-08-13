package menu;

public class Message {
    public static void chooseClass(String dashLine) {
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

    public static void chooseHowToFillArr(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Выберите способ заполнения исходного массива:");
        System.out.println("1 - Чтение из файла");
        System.out.println("2 - Случайным образом");
        System.out.println("3 - Ручками");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }

    public static void wantSomeSearch(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Хочешь найти нужный тебе объект?");
        System.out.println("1 - Да");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }

    public static void whatToSearch(String dashLine) {
        System.out.println(dashLine);
        System.out.println("- Напиши, что ты ищешь в формате: 'car,power,100'.");
        System.out.println("1 - car (power, model, year)");
        System.out.println("2 - book (author, name, pages)");
        System.out.println("3 - rootcrop (type, weight (формат 0 или 0.0), color)");
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
        System.out.println("1 - MergeSort");
        System.out.println("2 - MergeSortOddEven");
        System.out.println("0 - Выход");
        System.out.println(dashLine);
    }
}
