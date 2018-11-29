package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import model.Student;
import model.StudentNameComparator;

public class StudentApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Object Oriented Programming
		Student s1 = new Student("GONG MEITING",new Date("01/01/1996"),"S1234569H", "Quiet",110);
		Student s2 = new Student("NATHAN KOO LI WEI",new Date("01/01/1996"),"S1234565H", "Smile", 101);
		Student s3 = new Student("VINODHINI DHARMARAJ",new Date("01/01/1996"),"S1234567H", "Hide", 102);
		Student s4 = new Student("VINODHINI DHARMARAJ",new Date("01/01/1996"),"S1234567H", "Hide", 100);
		List<Student> list = new ArrayList<Student>();
		list.add(s1);list.add(s2);list.add(s3);
		if (s3.equals(s4)) {
			System.out.println("They are the same person - u idiot suria!!!!");
		} else {
			System.out.println("They are not the same person - u idiot suria!!!!");
		}
		for (Student student : list) {
			System.out.println(student.toString());
		}
		Collections.sort(list);
		System.out.println("Compare NRIC");
		for (Student student : list) {
			System.out.println(student.toString());
		}
		Collections.sort(list, new StudentNameComparator());
		System.out.println("Compare Name");
		for (Student student : list) {
			System.out.println(student.toString());
		}
		// Functional Programming
		System.out.println("Compare Marks");
		list.sort((Student o1, Student o2)->o1.getMark()-o2.getMark());
		list.forEach((student)->System.out.println(student.toString()));
		System.out.println("Compare Nick Name");
		list.sort((Student o1, Student o2)->o1.getNickName().compareToIgnoreCase(o2.getNickName()));
		list.forEach((student)->System.out.println(student.toString()));
		

	}

}
