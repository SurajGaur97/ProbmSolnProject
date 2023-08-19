package programsProblem.practice.array;

import java.util.Vector;

public class VectorExample {
	public void vectorEg(String[] args) {
		Vector<String> v = new Vector<>();
		
		for(String str: args) {
			v.add(str);
		}
		
		System.out.println(v);
	}
}
