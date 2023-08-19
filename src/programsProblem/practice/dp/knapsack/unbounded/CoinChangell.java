package programsProblem.practice.dp.knapsack.unbounded;

public class CoinChangell {
    public int coinChange(int[] coins, int amount, int size) {
        if(size == 0)
            return Integer.MAX_VALUE - 1;
        if(amount == 0)
            return 0;
        if(size == 0 && amount == 0)
            return Integer.MAX_VALUE - 1;

        if(coins[size - 1] <= amount) {
            //min-of(chosen + 1, non-chosen)
            return Math.min(1 + coinChange(coins, amount - coins[size - 1], size),
                    coinChange(coins, amount, size - 1));
        }
        else {
            //non-chosen
            return coinChange(coins, amount, size - 1);
        }
    }
    public int coinChange1(int[] coins, int amount) {
        int[][] t = new int[coins.length + 1][amount + 1];

        for(int i = 0; i < coins.length + 1; i++) {
            for(int j = 0; j < amount + 1; j++) {
                if(i == 0)
                    t[i][j] = Integer.MAX_VALUE - 1;
                if(j == 0)
                    t[i][j] = 0;
                if(i == 0 && j == 0)
                    t[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        for(int i = 0; i < coins.length + 1; i++) {
            for(int j = 0; j < amount + 1; j++) {
                if(coins[i - 1] <= j)
                    t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        return t[coins.length][amount];
    }

}
