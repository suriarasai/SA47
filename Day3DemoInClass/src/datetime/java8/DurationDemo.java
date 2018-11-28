package datetime.java8;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationDemo {

	public static void main(String[] args) {
		LocalDateTime dateTimeA = LocalDateTime
                .of(2015, 1, 26, 8, 10, 0, 0);
        LocalDateTime dateTimeB = LocalDateTime
                .of(2015, 1, 26, 11, 40, 0, 0);
        Duration duration = Duration.between(
                dateTimeA, dateTimeB);
        System.out.printf("There are %d hours and %d minutes.%n",
                duration.toHours(), 
                duration.toMinutes() % 60);

	}

}
