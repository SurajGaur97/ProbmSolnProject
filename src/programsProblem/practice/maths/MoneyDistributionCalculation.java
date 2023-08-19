package programsProblem.practice.maths;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MoneyDistributionCalculation {
	
	public void calculateMoney(Map<String, Integer> data) {
		int noOfPersons = data.size();
		Map<String, String> resHm = new LinkedHashMap<>(); 
		
		int totalSum = 0;

		for(Integer money: data.values()) {
			totalSum += money;
		}
		
		int perHead = totalSum / noOfPersons;
		
		for(Entry<String, Integer> entry: data.entrySet()) {
			int calc = entry.getValue() - perHead;
			resHm.put(entry.getKey(), (calc >= 0) ? ("+" + calc) : (String.valueOf(calc)));
		}
		
		for(Entry<String, String> ent: resHm.entrySet()) {
			System.out.println(ent.getKey() + ": " + ent.getValue());
		}
		
		System.out.println("\nHint ->\n'+' mean he need to take money\n'-' mean he need to pay.");
		
	}
}
