package datetime.java8;

import java.time.LocalDate;
import java.time.Period;

public class PeriodDemo {

	public static void main(String[] args) {
		
		LocalDate dateA = LocalDate.of(1978, 8, 26);
		LocalDate dateB = LocalDate.of(1988, 9, 28);
		Period period = Period.between(dateA, dateB);
		System.out.printf("Between %s and %s" + " there are %d years, %d months" + " and %d days%n", dateA, dateB,
				period.getYears(), period.getMonths(), period.getDays());

	}

}
