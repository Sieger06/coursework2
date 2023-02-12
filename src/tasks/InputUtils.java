package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtils {
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final String DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    public static String askString(String message) {
        System.out.print(message + ": ");
        return scanner.next();
    }

    public static int askInt(String message) {
        System.out.println(message + ": ");
        return scanner.nextInt();
    }

    public static LocalDate askDate(String message) {
        System.out.print(message + " (" + DATE_FORMAT + "): ");
        var strDate = scanner.next();
        return LocalDate.parse(strDate, DATE_FORMATTER);
    }

    public static LocalDateTime askDateTime(String message) {
        System.out.println(message + " (" + DATE_TIME_FORMAT + "): ");
        var strDateTime = scanner.next();
        return LocalDateTime.parse(strDateTime, DATE_TIME_FORMATTER);
    }

    public static String dateTimeToString(LocalDateTime dateTime) {
        return DATE_TIME_FORMATTER.format(dateTime);
    }
}
