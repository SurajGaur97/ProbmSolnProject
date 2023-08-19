package programsProblem.target75.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * Longest Substring Without Repeating Characters
	 * Given a string s, find the length of the longest substring without repeating characters.
	 * 
	 * Example 1:
	 * Input: s = "abcabcbb"
	 * Output: 3
	 * Explanation: The answer is "abc", with the length of 3.
	 * 
	 * Example 2:
	 * Input: s = "bbbbb"
	 * Output: 1
	 * Explanation: The answer is "b", with the length of 1.
	 * 
	 * Example 3:
	 * Input: s = "pwwkew"
	 * Output: 3
	 * Explanation: The answer is "wke", with the length of 3.
	 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 * @param s
	 * @return
	 */
	//100% works
	public int lengthOfLongestSubstring1(String s) {
		if(s.length() == 0) return 0;
		int i = 0, j = 0;
		int max = Integer.MIN_VALUE;
		HashSet<Character> set = new HashSet<>();
		while(j < s.length()) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
			}
			else {
				set.removeAll(set);
				i = j + 1;
				j = i + 1;
			}
			max = Math.max(max, set.size());
		}
				
		return max;
	}
	
	//Not worked 100%
	public int lengthOfLongestSubstring(String s) {
		String res = "";
		Set<String> set = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			String chars = Character.toString(s.charAt(i));
			if(!res.contains(chars)) {
				res += chars;
			}
			else {
				set.add(res);
				res = "";
				i--;
			}
		}
		
		int max = 0;
		for(String str : set) {
			if(max < str.length())
				max = str.length();
		}
		return max;
	}
}
