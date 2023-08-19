package programsProblem.leetcodeMustDo.array;

public class BestTimeToBuyAndSellStock {
	
    public int maxProfit(int[] prices) {
    	int max = 0;
    	
    	for(int i = 0, j = 1; j < prices.length; j++) {
    		if(prices[i] < prices[j]) {
    			if(prices[j] - prices[i] > max) {
    				max = prices[j] - prices[i]; 
    			}
    		}
    		else {
    			i = j;
    		}
    	}
    	
    	return max;
    }
}
