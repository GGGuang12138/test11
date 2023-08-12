package offer.of60;

import java.util.Arrays;

/**
 * @author Alan
 * @Description
 * @date 2023.08.12 16:20
 */
class Solution {
    // 1、暴力法，分母为6^n个，分子为[n,6n]个情况，6n-n+1 = 5n+1总情况
    // 再分别求每个情况的个数 / 6^n
    // 1、动归。定义dp[]数组为 i个骰子,和为j。
    // 状态转移方程。dp[i][j] 为 dp[i-1][j-1] * 1/6 + dp[i-1][j-2] * 1/6 +
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        // n为1的情况
        Arrays.fill(dp,1.0/6.0);
        // n大于2的情况
        for(int i = 2; i <= n; i ++){
            double[] tmp = new double[i*5+1];
            // 遍历前面一排，确定更新后一排的结果
            for(int j = 0; j < dp.length; j++){
                for(int k = 0; k < 6; k++){
                    tmp[j+k] += dp[j] / 6.0;
                }
            }
            // 更新新的一排
            dp = tmp;
        }
        return dp;
    }
}
