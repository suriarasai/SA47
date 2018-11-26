
public class CarTest {

	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car(1, "Honda City", "Uncle Cars", "Always works but expensive", 130000.00);
		Car c3 = new Car(1, "Honda City", "Uncle Cars", "Always works but expensive", 130000.00);
		System.out.println("Hash Code for C2 is "+c2.hashCode());
		System.out.println("Hash Code for C3 is "+c3.hashCode());
		int x = c2.getId();
		if (c2.equals(c3)) {
			System.out.println("They are same cars");
		} else {
			System.out.println("They are different cars");
		}
		
		System.out.println("name of the car is"+c2.getName());
	}
}
