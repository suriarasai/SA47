package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class SimpleDemo {
	
	public static void main(String[] args) {

	HashSet<String> s = new HashSet <String>();
    ArrayList<String> a = new ArrayList <String>();
    LinkedList<String> l = new LinkedList <String>();
    LinkedHashSet<String> lhs = new LinkedHashSet <String>();
    s.add("Sunday"); s.add("Monday");
    s.add("Sunday");
    a.add(0,"A"); a.add(1,"A"); a.add(2,"B");
    for(String current: s)
    	System.out.println(current);
    for(String current: a)
    	System.out.println(current);
    System.out.println("Print by index");
    System.out.println(a.get(2));
    System.out.println("Size" + s.size() + " " + a.size());
    
    
	}
    
}
