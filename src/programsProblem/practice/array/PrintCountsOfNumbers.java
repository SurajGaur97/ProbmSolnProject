package programsProblem.practice.array;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintCountsOfNumbers {
	
	public HashMap<Integer, Integer> returnCount(ArrayList<Integer> arr){
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < arr.size(); i++) {
			if(!hm.containsKey(arr.get(i))) {
				hm.put(arr.get(i), 1);
			}
			else {
				hm.put(arr.get(i), hm.get(arr.get(i)) + 1);
			}
		}
		
		return hm;
	}
}
