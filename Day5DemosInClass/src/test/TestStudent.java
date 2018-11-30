package test;

import java.util.ArrayList;
import java.util.Collections;

import model.Student;
import model.StudentNameComparator;
import model.StudentNickComparator;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s1 = new Student(1, "ONG HONG DAH", "Money");
		Student s2 = new Student(5, "PARINITA CHOWDHARY", "Summary Girl");
		Student s3 = new Student(3, "MAY THAZIN SOE", "Pleasant");
		Student s4 = new Student(2, "ZHOU SHUXIAN", "Lion King");
		Student s5 = new Student(4, "NATASHA TYAAN LEE", "Hiding");
		ArrayList<Student> slist = new ArrayList<Student>();
		slist.add(s1);
		slist.add(s2);
		slist.add(s3);
		slist.add(s4);
		slist.add(s5);
		// id - primary - Comparable
		// name - secondary arrange - Comparator
		// nick - Comparator
		System.out.println("Not Sorted");
		for (Student current : slist)
			System.out.println(current.toString());
		System.out.println("Sorted");
		Collections.sort(slist);
		for (Student current : slist)
			System.out.println(current.toString());
		// Secondary Comparision
		System.out.println("Names Sorted");
		Collections.sort(slist, new StudentNameComparator());
		for (Student current : slist)
			System.out.println(current.toString());
		// Secondary Comparision
		System.out.println("Nick Names Sorted");
		Collections.sort(slist, new StudentNickComparator());
		for (Student current : slist)
			System.out.println(current.toString());
	}

}
