package exceptionmgmt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptioDemo {

	public static void main(String[] args) throws FileNotFoundException {
		// 1. Create some file (manual)
		// 2. Two pieces of data (int) (manual)
		// 3. File or FileReader (File go missing, File could be corrupt)
		// 4. Scanner -> File (Connect to Scanner)
		// 5. Read the data (Data need not int)
		// 6. Sum - (-ve numbers? 0)
		// 7. Print result on console (null)
		
		// a= b+c;  1. Positive test 2. negative 3. destructive
		
		// Exception
		
		
		try {
			Scanner scan = new Scanner(new FileReader("D:\\temp\\silly.txt"));
			int sum = 0;
			int stupidanswer = scan.nextInt();
			while(scan.hasNextInt()) {
				int t = scan.nextInt();
				sum+=t;
			}
			System.out.println("TOTAL IS "+sum);
			scan.close();
		} catch (FileNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Corrective Action
		} catch (InputMismatchException ex) {
		
			Scanner scan1 = new Scanner(new FileReader("D:\\temp\\silly.txt"));
			int sum = 0;
			String s2 = scan1.nextLine();
			System.out.println(s2);
			scan1.close();
			
		}
		


	}

}
