package datetime.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeZoneTest {

    public void display(ZonedDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
        
        System.out.println(time.format(formatter));
        System.out.println();
    }

    public static void main(String args[]) {
        TimeZoneTest tztest = new TimeZoneTest();
        
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");  // or "+0900"
        ZoneId parisZone = ZoneId.of("Europe/Paris"); // or "+0200"
        
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime tokyoTime = ZonedDateTime.now(tokyoZone);
        ZonedDateTime parisTime = ZonedDateTime.now(parisZone);
        
        System.out.println("Time according to current machine");
        System.out.println(now);
        tztest.display(now);

        System.out.println("Time in Tokyo");
        tztest.display(tokyoTime);

        System.out.println("Time in Paris");
        tztest.display(parisTime);
        
        /**
         * More examples
         */
        System.out.println();
        System.out.println(" --- Assigning time zone works differently on LocalDateTime and Instant objects ---");
        System.out.println(LocalDateTime.now().atZone(parisZone));
        System.out.println(Instant.now().atZone(parisZone));
        
        System.out.println();
        System.out.println(" --- Convert LocalDateTime from one time zone to another ---");
        LocalDateTime labourDay = LocalDateTime.of(2018,5,1,12,59,59);
        System.out.println(labourDay.atZone(tokyoZone));
        System.out.println(labourDay.atZone(tokyoZone).withZoneSameLocal(parisZone));
        System.out.println(labourDay.atZone(tokyoZone).withZoneSameInstant(parisZone));
        
        System.out.println();
        System.out.println(" ---  Convert ZonedDateTime from one time zone to another ---");
        ZonedDateTime labourDayTokyo = ZonedDateTime.of(labourDay, tokyoZone);
        System.out.println(labourDayTokyo);
        System.out.println(labourDayTokyo.withZoneSameLocal(parisZone));
        System.out.println(labourDayTokyo.withZoneSameInstant(parisZone));
        
    }
}
