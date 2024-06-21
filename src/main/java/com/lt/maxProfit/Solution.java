package com.lt.maxProfit;

/**
 * @author Alan
 * @Description
 * @date 2023.12.18 23:04
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i ++){
            maxProfit = Math.max(prices[i]- min,maxProfit);
            min = Math.min(prices[i],min);
        }
        return maxProfit;
    }
}
