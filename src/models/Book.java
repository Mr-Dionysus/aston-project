package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Book {
    private final String author;
    private final String name;
    private final int pages;

    Book(Builder builder) {
        this.author = builder.author;
        this.name = builder.name;
        this.pages = builder.pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
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
            this.author = author;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public static ArrayList<Book> createObjects(int length){
        ArrayList<Book> bookList = new ArrayList<>();

        for (int i = 0; i < length; i++){
            bookList.add(new Book.Builder().author(randomAuthor()).name(randomName()).pages(randomPages()).build());
        }

        return bookList;
    }

    static String[] authors = {"Лев Толстой", "Фёдор Достоевский", "Михаил Булгаков", "Эрнест Хемингуэй", "Стивен Кинг",
            "Антуан де Сент-Экзюпери", "Александр Дюма", "Артур Конан Дойл", "Агата Кристи", "Фрэнсис Скотт Фицджеральд"};
    Map<String, String> booksMap = new HashMap<>();
    {
        booksMap.put("Лев Толстой", "Война и мир");
        booksMap.put("Лев Толстой", "Анна Каренина");
        booksMap.put("Фёдор Достоевский", "Преступление и наказание");
        booksMap.put("Фёдор Достоевский", "Идиот");
        booksMap.put("Михаил Булгаков", "Мастер и Маргарита");
        booksMap.put("Михаил Булгаков", "Белая гвардия");
        booksMap.put("Эрнест Хемингуэй", "Старик и море");
        booksMap.put("Эрнест Хемингуэй", "По ком звонит колокол");
        booksMap.put("Стивен Кинг", "Сияние");
        booksMap.put("Стивен Кинг", "Оно");
        booksMap.put("Антуан де Сент-Экзюпери", "Маленький принц");
        booksMap.put("Антуан де Сент-Экзюпери", "Планета людей");
        booksMap.put("Александр Дюма", "Три мушкетёра");
        booksMap.put("Александр Дюма", "Граф Монте-Кристо");
        booksMap.put("Артур Конан Дойл", "Приключения Шерлока Холмса и доктора Ватсона");
        booksMap.put("Артур Конан Дойл", "Собака Баскервилей");
        booksMap.put("Агата Кристи", "Убийство в Восточном экспрессе");
        booksMap.put("Агата Кристи", "Десять негритят");
        booksMap.put("Фрэнсис Скотт Фицджеральд", "Великий Гэтсби");
        booksMap.put("Фрэнсис Скотт Фицджеральд", "Ночь нежна");
    }
    
    static Random random = new Random();

    private static String randomAuthor() {
        return "";
    }

    private static String randomName() {
        return "";
    }

    private static int randomPages() {
        return 1;
    }
}
