package com.lt.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alan
 * @Description
 * @date 2023.08.14 23:44
 */
public class Solution {

    public static void main(String[] args) {
        threeSum(new int[]{1,-1,-1,0});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 三元组的顺序并不重要。避免重复，三个元素从小到大开始找
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i ++){
            // 跳过重复项
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int l = i+1;
            int r = nums.length - 1;
            while(l < r){
                if(nums[l] + nums[r] == target){
                    res.add(List.of(nums[i],nums[l],nums[r]));
                    l++;
                    // 跳过重复项
                    while(l < r && nums[l] == nums[l-1]){
                        l ++;
                    }
                    r --;
                    while(l < r && nums[l] == nums[r+1]){
                        r --;
                    }
                }else if (nums[l] + nums[r] > target){
                    r --;
                }else{
                    l ++;
                }
            }
        }
        return res;
    }
}
