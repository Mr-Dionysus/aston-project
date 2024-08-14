package strategy.fillmanually;

import exceptions.ValidateException;
import models.Book;

import java.util.Scanner;

public class BookFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually() {
        Book.Builder bookBuilder = new Book.Builder();
        boolean status = false;
        Scanner scanner = new Scanner(System.in);
        String input;
        int pages;

        while (!status) {
            System.out.print("Введите автора книги: ");
            input = scanner.next();
            bookBuilder.author(input);
            status = true;
        }
        status = false;

        while (!status) {
            System.out.print("Введите название книги: ");
            input = scanner.next();
            bookBuilder.name(input);
            status = true;
        }
        status = false;

        while (!status) {
            System.out.print("Введите количество страниц в книге от 1 до 1000: ");
            input = scanner.next();
            if (input.matches("^[0-9]+$") && Integer.parseInt(input) > 0 && Integer.parseInt(input) <=1000) {
                pages = Integer.parseInt(input);
                bookBuilder.pages(pages);
                status = true;
            }else {System.out.println("Неверные данные");}
        }

        return (T) bookBuilder.build();
    }
}
