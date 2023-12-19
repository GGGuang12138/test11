package leetcode.maxProfit2;

/**
 * @author Alan
 * @Description
 * @date 2023.12.19 23:01
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int profit = 0;
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}