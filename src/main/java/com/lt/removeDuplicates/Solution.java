package com.lt.removeDuplicates;

/**
 * @author Alan
 * @Description
 * @date 2024.01.08 21:28
 */
class Solution {
    // 通过boolean类型判断重复次数，如果改成重复的可以出现三次则不行
    // 因为为有序的，可以通过nums[fast] != nums[slow - k] 判断是否等于前位的元素即可
    public int removeDuplicates(int[] nums) {
        int valid = 1;
        boolean repeated = false;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                // 已出现一次重复
                if(repeated){
                    continue;
                }
                repeated = true;
            }else{
                repeated = false;
            }
            nums[valid] = nums[i];
            valid++;
        }
        return valid;
    }
}