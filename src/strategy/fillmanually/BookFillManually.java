package strategy.fillmanually;

import exceptions.ValidateException;
import exceptions.Validation;
import models.Book;

import java.util.Scanner;

public class BookFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually(String dashLine) {
        Book.Builder bookBuilder = new Book.Builder();
        boolean status = false;
        Scanner scanner = new Scanner(System.in);
        String input;

        while (!status) {
            try {
                System.out.print("Введите автора книги: ");
                input = Validation.removeSymbolsNums(scanner.nextLine());
                bookBuilder.author(input);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            try {
                System.out.print("Введите название книги: ");
                input = Validation.removeSymbols(scanner.nextLine());
                bookBuilder.name(input);
                status = true;
            } catch (ValidateException e) {
                System.out.println("Неверные данные");
            }
        }
        status = false;

        while (!status) {
            try {
                System.out.print("Введите количество страниц в книге от 1 до 1000: ");
                input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
                int pages = Integer.parseInt(input);
                bookBuilder.pages(pages);
                status = true;
            } catch (ValidateException | NumberFormatException e) {
                System.out.println("Неверные данные");
            }
        }

        return (T) bookBuilder.build();
    }
}
