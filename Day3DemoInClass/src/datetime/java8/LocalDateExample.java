package datetime.java8;

import java.time.*;

public class LocalDateExample {

    public static void printRenewDate(LocalDate fromDate, int daysValid) {
        LocalDate renewDate = fromDate.plusDays(daysValid);
        
        int extraDays = 0;
        if (renewDate.getDayOfWeek() == DayOfWeek.SATURDAY)
            extraDays = 2;
        if (renewDate.getDayOfWeek() == DayOfWeek.SUNDAY)
            extraDays = 1;
        
        renewDate = renewDate.plusDays(extraDays);
        System.out.println("Renewal date is " + renewDate);
    }

    public static void main(String[] args) {
        printRenewDate(LocalDate.now(), 14);
        printRenewDate(LocalDate.of(2017, 5, 26), 14);
        
        LocalDate today = LocalDate.now();
        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getMonthValue());
        System.out.println(today.getDayOfMonth());
        
    }
}
