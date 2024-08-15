package fillArr.random;

import models.Book;

import java.util.ArrayList;
import java.util.Random;

public class BookFillRandom implements FillRandomStrategy{
    // Данные для случайной генерации объекта
    String[] authors = {"Лев Толстой", "Фёдор Достоевский", "Михаил Булгаков", "Эрнест Хемингуэй", "Стивен Кинг", "Антуан де Сент-Экзюпери", "Александр Дюма", "Артур Конан Дойл", "Агата Кристи", "Фрэнсис Скотт Фицджеральд"};
    String[] names = {"Война и мир", "Анна Каренина", "Преступление и наказание", "Идиот", "Мастер и Маргарита", "Белая гвардия", "Старик и море", "Смешарики2", "Сияние", "Оно", "Маленький принц", "Планета людей", "Три мушкетёра", "Колобок", "Собака Баскервилей", "Десять негритят", "Ночь нежна"};

    Random random = new Random();

    private String randomAuthor() {
        return authors[random.nextInt(1, authors.length)];
    }

    private String randomName() {
        return names[random.nextInt(1, names.length)];
    }

    private int randomPages() {
        return random.nextInt(1, 500);
    }

    @Override
    public ArrayList<Book> fillRandom(int size) {
        ArrayList<Book> bookList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bookList.add(new Book.Builder().author(randomAuthor()).name(randomName()).pages(randomPages()).build());
        }

        return bookList;
    }




}
