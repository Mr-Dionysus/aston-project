package models;

import exceptions.ValidateException;

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
            if  (!author.isEmpty() && !author.matches("-?\\d+")){
                this.author = author;
            } else {
                throw new ValidateException("Ошибка валидации");
            }
            return this;
        }

        public Builder name(String name) {
            if  (!name.isEmpty() && !name.matches("-?\\d+")){
                this.name = name;
            } else {
                throw new ValidateException("Ошибка валидации");
            }
            return this;
        }

        public Builder pages(int pages)  {
            if  (0 < pages && pages <= 1000){
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
}
