package programsProblem.target75.bitManupulation;

public class CountingBits {
	/** #3
	 * 338. Counting Bits
	 * Problem Link: https://leetcode.com/problems/counting-bits/
	 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
	 * ans[i] is the number of 1's in the binary representation of i.
	 * 
	 * Example 1:
	 * Input: n = 2
	 * Output: [0,1,1]
	 * Explanation:
	 * 0 --> 0
	 * 1 --> 1
	 * 2 --> 10
	 * 
	 * Example 2:
	 * Input: n = 5
	 * Output: [0,1,1,2,1,2]
	 * Explanation:
	 * 0 --> 0
	 * 1 --> 1
	 * 2 --> 10
	 * 3 --> 11
	 * 4 --> 100
	 * 5 --> 101
	 * 
	 * @param n
	 * @return int
	 */
	public int[] countBits(int n) {
		int[] ans = new int[n + 1];
		ans[0] = 0;
		
        for(int i = 1; i <= n; i++) {
        	if(i % 2 == 0) {
        		ans[i] = ans[i/2];
        	}
        	else {
        		ans[i] = ans[i - 1] + 1;
        	}
        }
        
        return ans;
    }
}
