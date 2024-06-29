package com.lt.longestConsecutive;

import java.util.*;

/**
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * @author Alan
 * @Description
 * @date 2024.06.29 15:26
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        // 转成set用来判断是否存在
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;
        for (Integer num:set){
            // 当前元素-1不存在，才有可能是最长序列的开头
            if (!set.contains(num-1)){
                int currStreak = 1;
                int i = num+1;
                while (set.contains(i++)){
                    currStreak++;
                }
                longestStreak = Math.max(longestStreak,currStreak);
            }
        }
        return longestStreak;
    }
}
