package com.lt.halfOfTarget;

import java.util.List;
import java.util.Scanner;

/**
 *
 *
 * @author Alan
 * @Description
 * @date 2024.03.18 19:30
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer length = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        String[] split = line.split(" ");

        // 计算一半和
        int[] nums = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(split[i].trim());
            sum += nums[i];
        }
        // 一半和为奇数
        if (sum % 2 != 0) {
            System.out.println("-1");
            return;
        }
        // 求和为一半的最小个数
        int target = sum / 2;
        int[] dp = new int[target + 1]; // 和达到target的最小个数
        // 初始化最坏的情况
        for (int i = 1; i <= target; i++) {
            dp[i] = length;
        }
        for (int i = 0; i < length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.min(dp[j],dp[j-nums[i]]+1);
            }
        }
        if (dp[target] != length){
            System.out.println(dp[target]);
            return;
        }
        System.out.println("-1");
    }

}
