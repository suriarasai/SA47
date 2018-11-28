package datetime.java7;

import java.util.*;

public class TimeZoneTest {

    public void display(TimeZone timeZone) {
        Calendar myCalendar = Calendar.getInstance(timeZone);
        System.out.println("Hour=" + myCalendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute=" + myCalendar.get(Calendar.MINUTE));
        System.out.println("Second=" + myCalendar.get(Calendar.SECOND));
        System.out.println();
    }

    public static void main(String args[]) {
        TimeZoneTest tztest = new TimeZoneTest();

        TimeZone timeZoneDefault = TimeZone.getDefault(); // get default
                                                          // TimeZone
        TimeZone timeZoneSG = TimeZone.getTimeZone("GMT+0800"); // or specific
                                                                // TimeZone
        TimeZone timeZoneNZ = TimeZone.getTimeZone("GMT+1200"); // or specific
                                                                // TimeZone

        System.out.println("Time according to current machine");
        tztest.display(timeZoneDefault);

        System.out.println("Time in Singapore");
        tztest.display(timeZoneSG);

        System.out.println("Time in New Zealand");
        tztest.display(timeZoneNZ);
    }
}
