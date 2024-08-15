package fillArr.manually;

import menu.Err;
import menu.Message;
import models.Book;
import validation.Validation;

import java.util.Scanner;

public class BookFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually() {
        Book.Builder bookBuilder = new Book.Builder();
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean status = false;
        // Ввод автора
        while (!status) {
            Message.writeBookAuthor();
            input = Validation.removeSymbolsNums(scanner.nextLine());

            if (input.isEmpty()) {
                Err.emptyString();
                return null;
            } else if (input.equals("stop")) {
                return null;
            }

            bookBuilder.author(input);
            status = true;
        }

        status = false;
        // Ввод названия
        while (!status) {
            Message.writeBookName();
            input = Validation.removeSymbols(scanner.nextLine());

            if (input.isEmpty()) {
                Err.emptyString();
                return null;
            } else if (input.equals("0")) {
                return null;
            }

            bookBuilder.name(input);
            status = true;
        }

        status = false;
        // Ввод страниц
        while (!status) {
            Message.writeBookPages();
            input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
            int pages = Validation.bookPages(input);

            if (pages == -1) {
                Err.emptyString();
                return null;
            } else if (pages == 0) {
                return null;
            }

            bookBuilder.pages(pages);
            status = true;
        }

        return (T) bookBuilder.build();
    }
}
