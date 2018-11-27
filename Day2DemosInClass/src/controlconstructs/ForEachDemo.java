package controlconstructs;

public class ForEachDemo {
	
	public static void main(String args[]) {  
		
		for (int i = 0; i< 20; i++ ) {
			System.out.println("Number is " + i);
		}
		System.out.println();
		System.out.println("*********");
	    int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };  
	    int sum = 0;  
	 
	    // use for-each style for to display and sum the values 
	    for(int x : nums) {  
	      System.out.println("Value is: " + x); 
	      sum += x;  
	    }  
	    System.out.println("*********");
	 
	    System.out.println("Summation: " + sum); 
	  }  

}
