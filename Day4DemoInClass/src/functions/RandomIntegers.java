package functions;

// RandomIntegers.java
// Shifted and scaled random integers.
import java.security.SecureRandom;
import java.util.stream.Collectors;

public class RandomIntegers {
	public static void main(String[] args) {
		SecureRandom randomNumbers = new SecureRandom();

		// display 10 random integers on separate lines
		System.out.println("Random numbers on separate lines:");
		randomNumbers.ints(10, 1, 7).forEach(System.out::println);

		// display 10 random integers on the same line
		String numbers = randomNumbers.ints(10, 1, 7).mapToObj(String::valueOf).collect(Collectors.joining(" "));
		System.out.printf("%nRandom numbers on one line: %s%n", numbers);

	}
}

