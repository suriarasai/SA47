package generics;

import java.util.ArrayList;

public class TestingGenerics {

	public static void main(String[] args) {
		ArrayList<A> alist = new ArrayList<A>();
		B b1 = new B();
		C c1 = new C();
		alist.add(b1);
		alist.add(c1);
		for (A a : alist) {
			
		}
	}

}
