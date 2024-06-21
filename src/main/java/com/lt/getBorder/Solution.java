package com.lt.getBorder;

/**
 * @author Alan
 * @Description
 * @date 2024.05.23 17:42
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums,target);
        if(leftBorder == -1){
            return new int[]{-1,-1};
        }
        int rightBorder = getRightBorder(nums,target);
        return new int[]{leftBorder,rightBorder};
    }


    public int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                // 右指针依然移动，为了确定左边界
                right = mid - 1;
                leftBorder = mid;
            }else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }

    public int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                // 左指针依然移动，为了确定左边界
                rightBorder = mid;
                left = mid + 1;
            }else {
                left = mid + 1;
            }
        }
        return rightBorder;
    }
}
