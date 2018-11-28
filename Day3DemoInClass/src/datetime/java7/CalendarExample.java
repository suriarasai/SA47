package datetime.java7;

import java.util.*;

public class CalendarExample {

    public static void printRenewDate(Date fromDate, int daysValid) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fromDate);
        cal.add(Calendar.DATE, daysValid);
        int extraDays = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            extraDays = 2;
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            extraDays = 1;
        cal.add(Calendar.DATE, extraDays);
        System.out.println("Renewal date is " + cal.getTime());
    }

    public static void main(String[] args) {
        printRenewDate(new Date(), 14);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        System.out.println(Calendar.SUNDAY);
        System.out.println(Calendar.SATURDAY);
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.MONTH));

    }
}
