package models;

import java.util.ArrayList;
import java.util.Random;

import exceptions.ValidateException;

public class Book {
    private final String author;
    private final String name;
    private final int pages;

    static String[] authors = {"Лев Толстой", "Фёдор Достоевский", "Михаил Булгаков", "Эрнест Хемингуэй", "Стивен Кинг",
            "Антуан де Сент-Экзюпери", "Александр Дюма", "Артур Конан Дойл", "Агата Кристи", "Фрэнсис Скотт Фицджеральд"};

    static String[] names = {"Война и мир", "Анна Каренина", "Преступление и наказание", "Идиот", "Мастер и Маргарита",
            "Белая гвардия", "Старик и море", "Смешарики2", "Сияние", "Оно", "Маленький принц", "Планета людей",
            "Три мушкетёра", "Колобок", "Собака Баскервилей", "Десять негритят", "Ночь нежна"};

    Book(Builder builder) {
        this.author = builder.author;
        this.name = builder.name;
        this.pages = builder.pages;
    }

    public String getAuthor() {
        return author.toLowerCase();
    }

    public String getName() {
        return name.toLowerCase();
    }

    public int getPages() {
        return pages;
    }


    @Override
    public String toString() {
        return "Author: " + this.author + " | Name: " + this.name + " | Pages: " + this.pages;
    }

    public static class Builder {
        private String author;
        private String name;
        private int pages;

        public Builder author(String author) {
            if (!author.isEmpty() && !author.matches("-?\\d+")) {
                this.author = author;
            } else {
                throw new ValidateException("Ошибка валидации");
            }
            return this;
        }

        public Builder name(String name) {
            if (!name.isEmpty() && !name.matches("-?\\d+")) {
                this.name = name;
            } else {
                throw new ValidateException("Ошибка валидации");
            }
            return this;
        }

        public Builder pages(int pages) {
            if (0 < pages && pages <= 1000) {
                this.pages = pages;
            } else {
                throw new ValidateException("Ошибка валидации");
            }
            return this;
        }

        public Book build() throws ValidateException {
            return new Book(this);
        }
    }

    public static ArrayList<Book> createObjects(int length) {
        ArrayList<Book> bookList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            bookList.add(new Book.Builder().author(randomAuthor()).name(randomName()).pages(randomPages()).build());
        }

        return bookList;
    }

    static Random random = new Random();

    private static String randomAuthor() {
        return authors[random.nextInt(1, authors.length)];
    }

    private static String randomName() {
        return names[random.nextInt(1, names.length)];
    }

    private static int randomPages() {
        return random.nextInt(1, 500);
    }
}
