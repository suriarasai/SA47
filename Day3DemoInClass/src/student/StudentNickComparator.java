package student;

import java.util.Comparator;

public class StudentNickComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getNick().compareTo(o2.getNick());
	}

}
