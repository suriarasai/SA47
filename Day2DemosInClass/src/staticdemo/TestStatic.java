package staticdemo;

public class TestStatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       SimpleStaticDemo s1 = new SimpleStaticDemo();
       System.out.println(s1.SOME_STUPID_CONSTANT);
       System.out.println(s1.NONCHANGABLE_CONTANT);
       System.out.println(s1.getNormal());
       s1.SOME_STUPID_CONSTANT = 345;
       //s1.NONCHANGABLE_CONTANT = 1000; Not possible
       System.out.println(s1.SOME_STUPID_CONSTANT);
       SimpleStaticDemo s2 = new SimpleStaticDemo();
       System.out.println(s2.SOME_STUPID_CONSTANT);
       System.out.println(s2.getNormal());
       // making a class final = non import non new usage
       System.out.println(SimpleStaticDemo2.SOME_CONTANT);
       System.out.println(SimpleStaticDemo2.getPi());
	}

}
