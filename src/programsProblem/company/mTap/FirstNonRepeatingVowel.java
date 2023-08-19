package programsProblem.company.mTap;

import java.util.*;

public class FirstNonRepeatingVowel {
	/**
	 * Question: Find first non-repeating vowel in the string.
	 * Algo: First create a set of vowel for matching the vowels and filtering the chars from the string.
	 * Now create a LinkedHashMap that hold insertion orders (but not my HashMap that is why I have used 
	 * LinkedHashMap) and insert the counts of each vowels occured in the string.
	 * And atlast iterate through the map and check if the count of the vowel is 1 then the method should
	 * return that char, that will the final ans. 
	 * @param str
	 * @return
	 */
	public Character getVowel(String str) {		
		HashSet<Character> hs = new HashSet<>();
		hs.add('a');
		hs.add('e');
		hs.add('i');
		hs.add('o');
		hs.add('u');
		
		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
		for(int i = 0; i < str.length(); i++) {
			if(hs.contains(str.charAt(i))) {
				if(!hm.containsKey(str.charAt(i))) {
					hm.put(str.charAt(i), 1);
				}
				else {
					hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
				}
			}
		}
		
		for(Map.Entry<Character, Integer> entry: hm.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		
		return ' ';
	}
}
