package leetcode.bags;

/**
 * @author Alan
 * @Description
 * @date 2024.03.10 21:57
 */
public class Solution {

    public static void main(String[] args) {
        testCompletePackAnotherWay();
    }

    private static void testCompletePackAnotherWay(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++){ // 遍历背包容量
            for (int j = 0; j < weight.length; j++){ // 遍历物品
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                    System.out.println(dp[i]);
                }
            }
        }
    }
}
