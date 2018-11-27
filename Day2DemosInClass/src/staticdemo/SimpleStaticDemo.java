package staticdemo;

public class SimpleStaticDemo {
	
	// static 1. variables 2. methods 3 blocks 4 class
	public static int SOME_STUPID_CONSTANT = 789;
	public static final int NONCHANGABLE_CONTANT = 350;
	
	private int normal = 100;
	
	static {
		// static block
	    // only once - first time a new operator
		System.out.println("This is static inner block");
	}
	
	{
		// instance block 
		// every instance before constructor
		System.out.println("This is normal inner block");
	}

	
	public static void helloMessage() {
		System.out.println("THIS IS A STATIC METHOD");
		// Rule 1 - this keyword is not allowed
		// Rule 2 - static variables and other static methods
		int result = 0;
		result = SOME_STUPID_CONSTANT*3;
		double pi = java.lang.Math.PI;
	}


	public int getNormal() {
		return normal;
	}


	public void setNormal(int normal) {
		this.normal = normal;
	}
	
	
}
