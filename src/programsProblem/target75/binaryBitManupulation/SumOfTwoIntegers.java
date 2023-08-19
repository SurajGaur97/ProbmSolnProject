package programsProblem.target75.binaryBitManupulation;

public class SumOfTwoIntegers {
	
	/** #1
	 * 371. Sum of Two Integers
	 * Problem Link: https://leetcode.com/problems/sum-of-two-integers/
	 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
	 * 
	 * Example 1: 
	 * Input: a = 1, b = 2
	 * Output: 3
	 * 
	 * Example 2:
	 * Input: a = 2, b = 3
	 * Output: 5
	 * 
	 * @param a
	 * @param b
	 * @return int
	 */
	
	public int getSum(int a, int b) {
        while(b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }

        return a;
    }
}
