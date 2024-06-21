package com.lt.nearestDistance;

import java.util.Scanner;

/**
 * @author Alan
 * @Description
 * @date 2024.03.19 20:10
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        String x = split[0];
        String y = split[1];

        // 定义dp为抵达该节点的最短距离
        int[][] dp = new int[x.length()+1][y.length()+1];
        for(int i = 1; i < dp.length; i ++){
            dp[i][0] = i;
        }
        for (int i = 1; i < dp[0].length; i ++){
            dp[0][i] = i;
        }
        for (int i = 1;i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(dp[x.length()][y.length()]);


    }
}
