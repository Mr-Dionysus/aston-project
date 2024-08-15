package fillArr.manually;

import menu.Message;
import models.Book;
import validation.Validation;
import validation.ValidationException;

import java.util.Scanner;

public class BookFillManually implements FillManuallyStrategy {
    @Override
    public <T> T fillManually() {
        Book.Builder bookBuilder = new Book.Builder();
        boolean status = false;
        Scanner scanner = new Scanner(System.in);
        String input;
        // Ввод автора
        while (!status) {
            try {
                Message.writeBookAuthor();
                input = Validation.removeSymbolsNums(scanner.nextLine());

                if (input.isEmpty()) {
                    Message.emptyString();
                    return null;
                } else if (input.equals("stop")) {
                    return null;
                }

                bookBuilder.author(input);
                status = true;
            } catch (ValidationException e) {
                Message.invalidCommand();
            }
        }

        status = false;
        // Ввод названия
        while (!status) {
            try {
                Message.writeBookName();
                input = Validation.removeSymbols(scanner.nextLine());

                if (input.isEmpty()) {
                    Message.emptyString();
                    return null;
                } else if (input.equals("0")) {
                    return null;
                }

                bookBuilder.name(input);
                status = true;
            } catch (ValidationException e) {
                Message.invalidCommand();
            }
        }

        status = false;
        // Ввод страниц
        while (!status) {
            try {
                Message.writeBookPages();
                input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
                int pages = Validation.bookPages(input);

                if (pages == -1) {
                    Message.emptyString();
                    return null;
                } else if (pages == 0) {
                    return null;
                }

                bookBuilder.pages(pages);
                status = true;
            } catch (ValidationException | NumberFormatException e) {
                Message.invalidCommand();
            }
        }

        return (T) bookBuilder.build();
    }
}
