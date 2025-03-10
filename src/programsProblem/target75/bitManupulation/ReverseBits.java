package programsProblem.target75.bitManupulation;

public class ReverseBits {
	/**
	 * 190. Reverse Bits
	 * Problem Link: https://leetcode.com/problems/reverse-bits/description/
	 * Reverse bits of a given 32 bits unsigned integer.
	 * 
	 * Note: Note that in some languages, such as Java, there is no unsigned integer
	 * type. In this case, both input and output will be given as a signed integer
	 * type. They should not affect your implementation, as the integer's internal
	 * binary representation is the same, whether it is signed or unsigned. In Java,
	 * the compiler represents the signed integers using 2's complement notation.
	 * Therefore, in Example 2 above, the input represents the signed integer -3 and
	 * the output represents the signed integer -1073741825.
	 * 
	 * Example 1: Input: n = 00000010100101000001111010011100 Output:
	 * 964176192(00111001011110000010100101000000) Explanation: The input binary
	 * string 00000010100101000001111010011100 represents the unsigned integer
	 * 43261596, so return 964176192 which its binary representation is
	 * 00111001011110000010100101000000.
	 * 
	 * Example 2:
	 * 
	 * Input: n = 11111111111111111111111111111101 
	 * Output: 3221225471 (10111111111111111111111111111111) 
	 * Explanation: The input binary string
	 * 11111111111111111111111111111101 represents the unsigned integer 4294967293,
	 * so return 3221225471 which its binary representation is
	 * 10111111111111111111111111111111.
	 * 
	 * Follow up: If this function is called many times, how would you optimise it?
	 * 
	 * @param n
	 * @return int
	 */
	
	// you need treat n as an unsigned value
	//o(1)
    public int reverseBits(int n) {
        n = ((n & 0xffff0000) >> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        return n;
    }
    
    //o(n)
    /**
	 * We first intitialize result to 0. We then iterate from 0 to 31 (an integer
	 * has 32 bits). In each iteration: We first shift result to the left by 1 bit.
	 * Then, if the last digit of input n is 1, we add 1 to result. To find the last
	 * digit of n, we just do: (n & 1) Example, if n=5 (101), n&1 = 101 & 001 = 001
	 * = 1; however, if n = 2 (10), n&1 = 10 & 01 = 00 = 0).
	 * 
	 * Finally, we update n by shifting it to the right by 1 (n >>= 1). This is
	 * because the last digit is already taken care of, so we need to drop it by
	 * shifting n to the right by 1.
	 * 
	 * At the end of the iteration, we return result.
	 * 
	 * Example, if input n = 13 (represented in binary as
	 * 0000_0000_0000_0000_0000_0000_0000_1101, the "_" is for readability), calling
	 * reverseBits(13) should return: 1011_0000_0000_0000_0000_0000_0000_0000
	 * 
	 * Here is how our algorithm would work for input n = 13:
	 * 
	 * Initially, result = 0 = 0000_0000_0000_0000_0000_0000_0000_0000, n = 13 =
	 * 0000_0000_0000_0000_0000_0000_0000_1101
	 * 
	 * Starting for loop: i = 0: result = result << 1 =
	 * 0000_0000_0000_0000_0000_0000_0000_0000. n&1 =
	 * 0000_0000_0000_0000_0000_0000_0000_1101 &
	 * 0000_0000_0000_0000_0000_0000_0000_0001 =
	 * 0000_0000_0000_0000_0000_0000_0000_0001 = 1 therefore result = result + 1 =
	 * 0000_0000_0000_0000_0000_0000_0000_0000 +
	 * 0000_0000_0000_0000_0000_0000_0000_0001 =
	 * 0000_0000_0000_0000_0000_0000_0000_0001 = 1
	 * 
	 * Next, we right shift n by 1 (n >>= 1) (i.e. we drop the least significant
	 * bit) to get: n = 0000_0000_0000_0000_0000_0000_0000_0110. We then go to the
	 * next iteration.
	 * 
	 * i = 1: result = result << 1 = 0000_0000_0000_0000_0000_0000_0000_0010; n&1 =
	 * 0000_0000_0000_0000_0000_0000_0000_0110 &
	 * 0000_0000_0000_0000_0000_0000_0000_0001 =
	 * 0000_0000_0000_0000_0000_0000_0000_0000 = 0; therefore we don't increment
	 * result. We right shift n by 1 (n >>= 1) to get: n =
	 * 0000_0000_0000_0000_0000_0000_0000_0011. We then go to the next iteration.
	 * 
	 * i = 2: result = result << 1 = 0000_0000_0000_0000_0000_0000_0000_0100. n&1 =
	 * 0000_0000_0000_0000_0000_0000_0000_0011 &
	 * 0000_0000_0000_0000_0000_0000_0000_0001 =
	 * 0000_0000_0000_0000_0000_0000_0000_0001 = 1 therefore result = result + 1 =
	 * 0000_0000_0000_0000_0000_0000_0000_0100 +
	 * 0000_0000_0000_0000_0000_0000_0000_0001 = result =
	 * 0000_0000_0000_0000_0000_0000_0000_0101 We right shift n by 1 to get: n =
	 * 0000_0000_0000_0000_0000_0000_0000_0001. We then go to the next iteration.
	 * 
	 * i = 3: result = result << 1 = 0000_0000_0000_0000_0000_0000_0000_1010. n&1 =
	 * 0000_0000_0000_0000_0000_0000_0000_0001 &
	 * 0000_0000_0000_0000_0000_0000_0000_0001 =
	 * 0000_0000_0000_0000_0000_0000_0000_0001 = 1 therefore result = result + 1 = =
	 * 0000_0000_0000_0000_0000_0000_0000_1011 We right shift n by 1 to get: n =
	 * 0000_0000_0000_0000_0000_0000_0000_0000 = 0.
	 * 
	 * Now, from here to the end of the iteration, n is 0, so (n&1) will always be 0
	 * and and n >>=1 will not change n. The only change will be for result <<=1,
	 * i.e. shifting result to the left by 1 digit. Since there we have i=4 to i =
	 * 31 iterations left, this will result in padding 28 0's to the right of
	 * result. i.e at the end, we get result =
	 * 1011_0000_0000_0000_0000_0000_0000_0000
	 * 
	 * This is exactly what we expected to get
	 * 
	 * @param n
	 * @return
	 */
    public int reverseBits1(int n) {
    	int result = 0;
    	
    	for(int i = 0; i < 32; i++) {
    		result = result << 1;
    		if((n & 1) == 1)
    			result = result + 1;
    		n = n >> 1;
    	}
    	
    	return result;
    }
}
