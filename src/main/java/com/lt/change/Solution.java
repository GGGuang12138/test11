package com.lt.change;

import java.util.Arrays;

/**
 * @author Alan
 * @Description
 * @date 2024.02.20 23:30
 */
public class Solution {

    public static void main(String[] args) {
        change2(5,new int[]{1,2,5});
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i ++){
            for(int j = coins[i]; j < amount+1; j++){
                dp[j] += dp[j-coins[i]];
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[amount];
    }

    public static int change2(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        // 只有一种硬币的情况
        for (int i = 0; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
            System.out.println(Arrays.deepToString(dp));
        }
        System.out.println();
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                // 第i种硬币使用0~k次，求和
                for (int k = 0; k * coins[i] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                    System.out.println(Arrays.deepToString(dp));

                }
            }
            System.out.println();
        }
        return dp[coins.length - 1][amount];
    }
}
