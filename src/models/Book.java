package models;

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
        return "Author: " + this.author + "; Name:   " + this.name + "; Pages:  " + this.pages;
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
}
