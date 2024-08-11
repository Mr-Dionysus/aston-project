package strategy;

import models.Book;
import models.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookReadFile implements ReadFileStrategy{
    @Override
    public List<Book> ReadFile() {
        List<Book> bookList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/books.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(":", 3);
                String author = values[0];
                String name = values[1];
                int pages = Integer.parseInt(values[2]);
                Book book = new Book.BookBuilder(author, name, pages).build();
                bookList.add(book);
            }
        } catch (IOException e) {
            System.out.println("Exception\n");
            bookList = Collections.emptyList();
        }
        return bookList;
    }
}
