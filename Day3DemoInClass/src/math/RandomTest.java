package math;

import java.util.Date;
import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        Random r = new Random();
        //System.out.println(r.nextInt(100));
        
        System.out.println(System.currentTimeMillis());

        Date d1 = new Date();

        for (int i = 0; i < 100000000; i++) {

        }
        System.out.println(System.currentTimeMillis());
        // long elapsedTime = d1.getTime(); // number of milliseconds since
        // epoch

        Date d2 = new Date();

        System.out.println(d1.getTime());
        System.out.println(d2.getTime());

        System.out.println(d1.before(d2));
        if (d2.after(new Date())) {
            System.out.println("yes");
        }
    }
}
