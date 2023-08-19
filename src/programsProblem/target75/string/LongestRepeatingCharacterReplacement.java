package programsProblem.target75.string;

import java.util.Collections;
import java.util.HashMap;

/*
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 */
//AABABBA
public class LongestRepeatingCharacterReplacement {
	
	public int characterReplacement1(String s, int k) {
		int l = 0, r = 0, maxLen = 0, i = 0, maxValueInMap = 0, winSize = 0;
		HashMap<Character, Integer> charCount = new HashMap<>();
		
		while(r < s.length()) {
			if(!charCount.containsKey(s.charAt(i))) {
				charCount.put(s.charAt(i), 1);
				i++;
			}
			else {
				charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
				i++;
			}
			
			maxValueInMap = Collections.max(charCount.values());
			winSize = r - l + 1;
			
			if(winSize - maxValueInMap <= k) {
				maxLen = Math.max(maxLen, winSize);
			}
			else {
				Character ch = s.charAt(l);
				charCount.put(ch, charCount.get(ch) - 1);
				l++;
			}
			
			r++;
		}
		
		return maxLen;
	}
	
	// 20/38 test case passes only.
	public int characterReplacement(String s, int k) {
        if(s.length() == 0) return 0;
        int i = 0, j = 0, tempK = k;
        char[] chars = s.toCharArray();
        int max = Integer.MIN_VALUE;
        while(j < chars.length - 1) {
        	if(chars[j] == chars[j + 1]) {
        		j++;
        	}
        	else if(tempK > 0){
                if(j != 0)
        		    chars[j + 1] = chars[j + 1] == 'A' ? 'B' : 'A';
                if(j == 0)
        		    chars[j] = chars[j] == 'A' ? 'B' : 'A';
        		tempK--;
        		j++;
        	}
        	else if(tempK == 0) {
        		tempK = k;
        		chars = s.toCharArray();
        		i++;
        		j = i;
        	}
        	max = Math.max(max, (j - i + 1));
        }
        return max;
    }
}
