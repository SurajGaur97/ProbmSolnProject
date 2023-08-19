package programsProblem.target75.dynamicProgramming;

public class ClimbingStairs {
	/**
	 * 70. Climbing Stairs
	 * Problem Link: https://leetcode.com/problems/climbing-stairs/
	 */
	
	public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        if(n > 1)
            arr[2] = 2;

        for(int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
