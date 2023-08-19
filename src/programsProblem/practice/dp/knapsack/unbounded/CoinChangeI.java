package programsProblem.practice.dp.knapsack.unbounded;

public class CoinChangeI {
    public int coinChange1(int[] coins, int amount, int size) {
        //base condition
        if(amount == 0)
            return 1;
        if(size == 0)
            return 0;
        if(amount == 0 && size == 0)
            return 0;

        //choice diagram
        if(coins[size - 1] <= amount) {
            //ways when chosen + ways when not chosen
            return coinChange1(coins, amount - coins[size - 1], size)
                    + coinChange1(coins, amount, size - 1);
        }
        else {
            //ways when not chosen
            return coinChange1(coins, amount, size - 1);
        }

    }
    public int coinChange(int amount, int[] coins) {
        int[][] t = new int[coins.length + 1][amount + 1];

        //base condition
        for(int i = 0; i < coins.length + 1; i++) {
            for(int j = 0; j < amount + 1; j++) {
                if(i == 0)
                    t[i][j] = 0;
                if(j == 0)
                    t[i][j] = 1;
                if(i == 0 && j == 0)
                    t[i][j] = 0;
            }
        }

        //choice diagram
        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(coins[i - 1] <= j)
                    t[i][j] = t[i - 1][j] + t[i][j - coins[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[coins.length][amount];
    }
}
