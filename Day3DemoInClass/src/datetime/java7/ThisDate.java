package datetime.java7;

import java.util.*;

public class ThisDate {
    /**
     * Sunday is the first day of the week for the Calendar Note: The
     * DAY_OF_WEEK value used by Calendar objects start at 1, (and our array of
     * strings starts at 0)
     */
    final static String[] DAYS = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    /**
     * define an array of strings that can translate between integer MONTH and
     * strings. According to a Calendar object, the first month (January) is
     * month 0.
     */
    static final String[] MONTHS = { "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };

    static public void main(String[] args) {
        Calendar c = Calendar.getInstance();
        try {
            int month, day, year;
            month = Integer.parseInt(args[0]);
            day = Integer.parseInt(args[1]);
            year = Integer.parseInt(args[2]);

            // January is month 0!
            c.set(Calendar.MONTH, month - 1);
            c.set(Calendar.YEAR, year);
            c.set(Calendar.DATE, day);
        } catch (Exception e) {
            // invalid or missing command line args, just
            // assume we should use the current month,year
        }
        System.out.println("The date is " + dayName(c) + " " + monthName(c) + " " + c.get(Calendar.DATE) + ", "
                + c.get(Calendar.YEAR));
    }

    /**
     * dayName looks up the string version of the day of the week for the date
     * in a Calendar object
     */
    static String dayName(Calendar c) {
        // Need to subtract 1, since the first DAY_OF_WEEK is 1 !
        return (DAYS[c.get(Calendar.DAY_OF_WEEK) - 1]);
    }

    /**
     * monthName looks up the string version of the month for the date in a
     * Calendar object
     */
    static String monthName(Calendar c) {
        return (MONTHS[c.get(Calendar.MONTH)]);
    }

}
