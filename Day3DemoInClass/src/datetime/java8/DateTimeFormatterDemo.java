package datetime.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DateTimeFormatter formatter1 = DateTimeFormatter
	                .ofLocalizedDateTime(FormatStyle.MEDIUM);
	        LocalDateTime example = LocalDateTime.of(
	                2000, 3, 19, 10, 56, 59);
	        System.out.println("Format 1: " + example
	                .format(formatter1));        
	        DateTimeFormatter formatter2 = DateTimeFormatter
	                .ofPattern("MMMM dd, yyyy HH:mm:ss");
	        System.out.println("Format 2: " + 
	                example.format(formatter2));

	}

}
