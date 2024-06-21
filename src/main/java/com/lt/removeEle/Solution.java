package com.lt.removeEle;

/**
 * @author Alan
 * @Description
 * @date 2024.05.27 10:26
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int valid = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == val){
                continue;
            }
            nums[valid] = nums[i];
            valid++;
        }
        return valid-1;
    }
}
