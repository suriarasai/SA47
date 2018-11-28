package datetime.java7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarExampleDateFormat {

    public static void printRenewDate(String enteredDate, int daysValid) throws ParseException {
        Date fromDate = null;
        SimpleDateFormat df = new SimpleDateFormat("d-MMM-yyyy");
        try {
            fromDate = df.parse(enteredDate);
        } catch (ParseException e) {
            System.out.println("Invalid format: " + enteredDate);
            throw e;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fromDate);
        cal.add(Calendar.DAY_OF_MONTH, daysValid);

        int extraDays = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            extraDays = 2;
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            extraDays = 1;
        cal.add(Calendar.DATE, extraDays);

        Date expiryDate = cal.getTime();
        System.out.println("Renewal date is " + df.format(expiryDate));
    }

    public static void main(String[] args) {
        try {
            printRenewDate("26-May-2017", 14);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}