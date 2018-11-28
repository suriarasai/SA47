package datetime.java8;

import java.time.*;

public class InstantExample {

    public static void main(String[] args) {

        Instant i1 = Instant.now();

        for (long i = 0; i < 1000000000; i++) { //System.out.println(); 
            
        }

        Instant i2 = Instant.now();

        System.out.println(i1);
        System.out.println(i2);
        System.out.println();

        System.out.println(i1.getEpochSecond()); // Gets the number of seconds
                                                 // since epoch
        System.out.println(i2.getEpochSecond());
        System.out.println();

        System.out.println((i1.isBefore(i2)));
        System.out.println((i2.isAfter(Instant.now())));
    }
}
