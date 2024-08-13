package strategy.fillmanually;

import exceptions.ValidateException;
import models.Book;

import java.util.Scanner;

public class BookFillManually implements FillManuallyStrategy{
    @Override
    public <T> T fillManually() {
        Book.Builder bookBuilder = new Book.Builder();
        boolean status = false;
        Scanner scanner = new Scanner(System.in);
        String line = "";

        while (!status) {
            System.out.print("Введи автора книги: ");
            try {
                line = scanner.next();
                bookBuilder.author(line);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            System.out.print("Введите название книги: ");
            try {
                line = scanner.next();
                bookBuilder.name(line);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            System.out.print("Введите количество страниц в книге от 1 до 1000: ");
            try {
                line = scanner.next();
                int pages = Integer.parseInt(line);
                bookBuilder.pages(pages);
                status = true;
            } catch (ValidateException | NumberFormatException e) {
                System.out.println("Неверные данные");
            }
        }

        return (T) bookBuilder.build();
    }
}
