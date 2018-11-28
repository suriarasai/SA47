package maps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

public class SimpleDemo {
	public static void main(String[] args) {
	 HashMap<String, String> h = new HashMap<String, String>();
     TreeMap<String, String> t = new TreeMap<String, String>();
     h.put("K1", "Some Data 1");
     h.put("K1", "Some Data 2");
     h.put("K1", "Some Data 3");
     h.put("K2", "Some Data 1");
     h.put("K2", "Some Data 2");
     String result = h.get("K1");
     
    if (h.containsKey("K1"))
     System.out.println(result);
     Collection<String> valuesK1 = new ArrayList<String>();
     
/*     valuesK1 = h.values();
     for(String current: valuesK1)
    	 System.out.println(current);*/
     
	}
}
