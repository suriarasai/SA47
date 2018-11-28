package datetime.java8;

import java.time.*;
import java.time.format.*;

public class LocalDateExampleDateFormat {

    public static void printRenewDate(String enteredDate, int daysValid) throws DateTimeParseException {
        
        LocalDate fromDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        
        try {
            fromDate = LocalDate.parse(enteredDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format: " + enteredDate);
            throw e;
        }
        
        LocalDate renewDate = fromDate.plusDays(daysValid);
        
        int extraDays = 0;
        if (renewDate.getDayOfWeek() == DayOfWeek.SATURDAY)
            extraDays = 2;
        if (renewDate.getDayOfWeek() == DayOfWeek.SUNDAY)
            extraDays = 1;
        
        renewDate = renewDate.plusDays(extraDays);
        
        System.out.println("Renewal date is " + renewDate.format(formatter));
        
        formatter = DateTimeFormatter.ofPattern("EEEE MMMM d, yyyy");
        System.out.println("Renewal date is " + renewDate.format(formatter));
        
        ZonedDateTime d = renewDate.atTime(11, 59, 59).atZone(ZoneId.of("+8"));
        System.out.println("Renewal date is " + d.format(DateTimeFormatter.RFC_1123_DATE_TIME));

    }

    public static void main(String[] args) {
        try {
            printRenewDate("26-May-2017", 14);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }

}