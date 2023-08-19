package programsProblem.practice.string;

import java.util.HashMap;

public class NoOfCorrespondingFragmentsCodility {
	
	public int solution4(String A, String B) {
		int count = 0;
		int strLength = A.length();
		HashMap<Character, Integer> letters = new HashMap<>();
		
		
		int noOfCharacterToBeChecked = 1;
		int startIndex = 0;
		while(noOfCharacterToBeChecked <= strLength) {
			
			int lastIndex = startIndex + noOfCharacterToBeChecked;
			//First get the characters in HashMap for the noOfLtters to be checked
			for(int i = startIndex; i < lastIndex; i++) {
				letters.put(A.charAt(i), letters.getOrDefault(A.charAt(i), 0) + 1);
			}
			//compare the second string and increase count if matched
			for(int i = startIndex; i < lastIndex; i++) {
				if(letters.containsKey(B.charAt(i))) {
					int letterCount = letters.getOrDefault(B.charAt(i), 0);
					if(letterCount > 1)  {
						letters.put(B.charAt(i), letters.getOrDefault(B.charAt(i), 0) - 1);
					} else {
						letters.remove(B.charAt(i));
					}
				} else {
					break;
				}
			}
			
			if(letters.isEmpty()) {
				count++;
			}
			letters.clear();
			//Check till last index
			if(lastIndex < strLength) {
				startIndex++;
			} else {
				//Once last index is reached increase noOfLetter to be checked and reset startIndex
				noOfCharacterToBeChecked++;
				startIndex = 0;
			}	
		}
		return count;
	}
	
	public int solution3(int[] A) {
		if(A.length == 0) return 0;
		int P = 0, Q = 0;
		int max = Integer.MIN_VALUE;
		while(Q < A.length - 1) {
			if(A[Q] < A[Q + 1]) {
				P = Q + 1;
				max = Math.max(max, P - Q + 1);	
			}
			Q++;
		}
		if(P == 0) {
			max = 1;
		}
		return max;
	}
	
	//qsn 1
	public int solution2(int[] A) {
	    int max_sum = A[0];
	    int sub_sum = A[0];

	    for (int i = 1; i < A.length; i++) {
	        sub_sum = Math.max(sub_sum + A[i], A[i]);
	        max_sum = Math.max(max_sum, sub_sum);
	    }

	    return max_sum;
	}
	
	//qsn 2
	public int solution1(String s) {
	    final char CHAR_A = 'A';
	    int num_Bs = 0, min_dels = 0;

	    for(char c : s.toCharArray()) {
	        if (CHAR_A == c) {
	            min_dels = Math.min(num_Bs, min_dels + 1);
	        }
	        else {
	            num_Bs++;
	        }
	    }
	    return min_dels;
	}
	
	//qsn 3
	public int solution(String A, String B) {
		int i = 0, j = 0, count = 0;
		int sumA = 0, sumB = 0;
		while (j < A.length()) {
			int charA = A.charAt(j);
			int charB = B.charAt(j);
			sumA += charA;
			sumB += charB;
			j++;
			if(sumA == sumB) {
				count++;
				sumA = 0;
				sumB = 0;
				i++;
				j = i;
			}
		}
		return count;
    }
}
