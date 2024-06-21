package com.lt.LCS;

/**
 * @author Alan
 * @Description
 * @date 2024.04.25 13:38
 */
public class Solution {
    public static void main(String[] args) {
        LCS("1AB2345CD","12345EF");
    }

    public static String LCS (String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLength = Integer.MIN_VALUE;
        int pos = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    pos = i - 1;
                }
            }
        }
        return str1.substring(pos - maxLength + 1, pos + 1);
    }
}
