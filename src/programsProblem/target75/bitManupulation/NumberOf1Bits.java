package programsProblem.target75.bitManupulation;

import programsProblem.utils.DriverClass;

public class NumberOf1Bits implements DriverClass<Integer> {

    /** #2
     * 191. Number of 1 Bits
     * Problem Link: https://leetcode.com/problems/number-of-1-bits/
     * Write a function that takes an unsigned integer and returns the number of '1' bits it has
     * (also known as the Hamming weight).
     *
     * Note:
     * Note that in some languages, such as Java, there is no unsigned integer type. In this case,
     * the input will be given as a signed integer type. It should not affect your implementation, as the
	 * integer's internal binary representation is the same, whether it is signed or unsigned.
	 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, 
	 * in Example 3, the input represents the signed integer. -3.
	 * 
	 * Example 1:
	 * Input: n = 00000000000000000000000000001011
	 * Output: 3
	 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
	 * 
	 * Example 2:
	 * Input: n = 00000000000000000000000010000000
	 * Output: 1
     * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
     *
     * Example 3:
     * Input: n = 11111111111111111111111111111101
     * Output: 31
     * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
     *
     * @param n
     * @return int
     */

    @Override
    public void driverMethod(){
        int n = 11;
        printElement(hammingWeight1(n));
    }

    public int hammingWeight1(int n){
        int count = 0;
        int bit = 1;

        while (n != 0){
            System.out.println(n + " : " + (n & 1));
            if((n & 1) != 0) count++;
            n = n >> 1;
        }

//		while(bit != 0) {
//			System.out.println(bit + " : " + (bit & n));
//			if((bit & n) != 0) count++;
//			bit = bit >> 1;
//		}

        return count;
    }

    public int hammingWeight(int n){
        int count = 0;
        while (n != 0){
            count = count + (n & 1);
            n = n >>> 1;
        }

        return count;
    }
}
