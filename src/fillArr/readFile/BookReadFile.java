package fillArr.readFile;

import models.Book;
import validation.Validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookReadFile implements ReadFileStrategy {
    @Override
    public ArrayList<Book> readFile() {
        ArrayList<Book> books = new ArrayList<>();
        String input;
        // Чтение данных из файла
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/books.txt"))) {
            while ((input = reader.readLine()) != null) {
                String[] values = input.split(":", 3);
                String author = Validation.removeSymbolsNums(values[0]);
                String name = Validation.removeSymbols(values[1]);
                String pagesString = Validation.removeSymbolsLettersSpaces(values[2]);
                int pages = Validation.bookPages(pagesString);
                Book book = new Book.Builder().author(author).name(name).pages(pages).build();

                if (pages == -1) {
                    book = null;
                }

                books.add(book);
            }
        } catch (IOException e) {
            System.out.println("Exception\n");
            books = null;
        }

        return books;
    }
}
