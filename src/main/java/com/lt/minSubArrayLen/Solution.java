package com.lt.minSubArrayLen;

/**
 * @author Alan
 * @Description
 * @date 2023.08.17 23:21
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int currSum = 0;
        int min = Integer.MAX_VALUE;
        while (j < nums.length) {
            currSum += nums[j];
            // 满足条件移动左指针
            while (i <= j && currSum >= target) {
                min = Math.min(min, j - i + 1);
                currSum -= nums[i];
                i++;
            }
            j++;

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

