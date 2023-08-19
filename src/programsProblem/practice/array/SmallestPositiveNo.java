package programsProblem.practice.array;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveNo {
	/**
	 * Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
	 */
	
	public int solution(int[] A) {
        // Implement your solution here
        int max = A[0], min = A[0];
        for(int i = 0; i < A.length; i++) {
            if(max < A[i]) {
                max = A[i];
            }
        }
        
        for(int i = 0; i < A.length; i++) {
            if(min > A[i]) {
                min = A[i];
            }
        }

        if(max <= 0) {
            return 1;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++) {
        	set.add(A[i]);
        }
        
        for(int i = min; i < max; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }

        return max + 1;
    }

}
