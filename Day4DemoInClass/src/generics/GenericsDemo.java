package generics;

public class GenericsDemo {
	
	// What is that Number Suria scream about?
	// Integer Float Double 
	public static <E extends Number, F extends Number> double sum(E x, F y) {
		return x.doubleValue() + y.doubleValue();
	}

	public double myGeniusMethod(Number x, Number y) {
		return 0;
	}

	public static void main(String[] args) {
		int x = 10, y = 20;
		long r = 10l, s = 20l;
		float e = 10f, f = 20f;
		double v = 10.0, w = 20.0;
		System.out.println(sum(x, y));
		System.out.println(sum(r, s));
		System.out.println(sum(e, f));
		System.out.println(sum(v, w));
		System.out.println(sum(x, v));
	}

}
