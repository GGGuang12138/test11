package com.lt.subarraySum;

import java.util.HashMap;
import java.util.Map;

/**560. 和为 K 的子数组
 *
 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 子数组是数组中元素的连续非空序列。

 输入：nums = [1,1,1], k = 2
 输出：2
 示例 2：

 输入：nums = [1,2,3], k = 3
 输出：2

 1 <= nums.length <= 2 * 104
 -1000 <= nums[i] <= 1000
 -107 <= k <= 107
 * @author Alan
 * @Description
 * @date 2024.07.02 15:32
 */
public class Solution {

    public int subarraySum(int[] nums, int k) {
        int l = 0,count = 0;
        while (l < nums.length){
            int r = l;
            int sum = 0;
            while (r < nums.length){
                sum += nums[r];
                if (sum == k){
                    count++;
                }
                r++;
            }
            l++;
        }
        return count;

    }

    public int subarraySum2(int[] nums, int k) {
        // 用来记录key为和、value为出现和的个数
        Map<Integer,Integer> map = new HashMap<>();
        // 初始化
        map.put(0,1);
        int count = 0, sum = 0;
        for (int num: nums){
            sum += num;
            // 获取可能的[i,j]个数
            count += map.getOrDefault(sum - k, 0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }
}
