package strategy.readfile;

import exceptions.ValidateException;
import models.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookReadFile implements ReadFileStrategy {
    @Override
    public ArrayList<Book> readFile() {
        ArrayList<Book> bookList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/books.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(":", 3);
                if (values.length == 3) {
                    String author = values[0];
                    String name = values[1];
                    int pages = Integer.parseInt(values[2]);
                    Book book = new Book.Builder().author(author).name(name).pages(pages).build();
                    bookList.add(book);
                }
            }
        } catch (IOException | ValidateException | NumberFormatException e) {
            System.out.println("Некоректные данные в файле");
            bookList = null;
        }
        return bookList;
    }
}
