package com.lt.searchRange;

/**
 * @author Alan
 * @Description
 * @date 2023.08.25 00:57
 */
public class Solution {
    private int findFirst(int[] nums, int target){
        // 遍历左必右开区间
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            // 等于mid不直接返回
            // 左的左边一定是小于target
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums,target);
        if(first == nums.length || nums[first] != target){
            return new int[]{-1,-1};
        }
        int second = findFirst(nums,target+1) - 1;

        return new int[]{first,second};
    }
}
