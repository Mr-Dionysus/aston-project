package strategy.fillmanually;

import exceptions.ValidateException;
import exceptions.Validation;
import menu.Message;
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
                Message.writeBookAuthor();
                input = Validation.removeSymbolsNums(scanner.nextLine());

                if (input.isEmpty()) {
                    Message.emptyString(dashLine);
                    return null;
                } else if (input.equals("stop")) {
                    return null;
                }

                bookBuilder.author(input);
                status = true;
            } catch (ValidateException e) {
                Message.invalidCommand(dashLine);
            }
        }
        status = false;

        while (!status) {
            try {
                Message.writeBookName();
                input = Validation.removeSymbols(scanner.nextLine());

                if (input.isEmpty()) {
                    Message.emptyString(dashLine);
                    return null;
                } else if (input.equals("0")) {
                    return null;
                }

                bookBuilder.name(input);
                status = true;
            } catch (ValidateException e) {
                Message.invalidCommand(dashLine);
            }
        }
        status = false;

        while (!status) {
            try {
                Message.writeBookPages();
                input = Validation.removeSymbolsLettersSpaces(scanner.nextLine());
                int pages = Validation.bookPages(input, dashLine);

                if (pages == -1) {
                    Message.emptyString(dashLine);
                    status = false;
                    return null;
                } else if (pages == 0) {
                    return null;
                }

                bookBuilder.pages(pages);
                status = true;
            } catch (ValidateException | NumberFormatException e) {
                Message.invalidCommand(dashLine);
            }
        }

        return (T) bookBuilder.build();
    }
}
