package programsProblem.practice.dp.gfg;

import java.util.Arrays;

public class CatalanNumber {
    public void driverMethod() {
        int n = 11;
        for(int i = 0; i < n; i++)
            System.out.print(getCatalanNumber1(i) + " ");

        System.out.println();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        for(int i = 0; i < n; i++)
            System.out.print(getCatalanNumber2(i, dp) + " ");

        System.out.println(getCatalanNumber3(n));
    }

    //Tabulation approach
    private int getCatalanNumber3(int num) {
        int[] t = new int[num + 1];

        //Base condition
        t[0] = t[1] = 1;

        for(int i = 2; i <= num; i++) {
            for(int j = 0; j < i; j++) {
                t[i] += t[j] * t[i - j - 1];
            }
        }
        return t[num];
    }

    //Recursive memoization method
    private int getCatalanNumber2(int num, int[] dp) {
        if(num <= 1) return 1;

        if(dp[num] != -1) return dp[num];

        int res = 0;
        for(int i = 0; i < num; i++) {
            res += getCatalanNumber2(i, dp) * getCatalanNumber2(num - i - 1, dp);
            dp[num] = res;
        }

        return dp[num];
    }

    //Recursive method
    private int getCatalanNumber1(int num) {
        if(num <= 1) return 1;

        int result = 0;
        for(int i = 0; i < num; i++) {
            result += getCatalanNumber1(i) * getCatalanNumber1(num - i - 1);
        }

        return result;
    }

    //iterative approach. (Failed for values of n > 11)
    private long getCatalanNumber(int num) {
        long factNum = 1L, fact2num = 1L, factNumPlus1 = 1L;

        for(int i = 0; i < num; i++) {
            factNum *= num - i;
        }
        for(int i = 0; i < 2 * num; i++) {
            fact2num *= (2L * num - i);
        }
        factNumPlus1 = factNum * (num + 1);

        return fact2num / (factNumPlus1 * factNum);
    }
}
