package com.lt.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        // 遍历第一个
        for(int i = 0; i < nums.length - 3; i ++){
            int first = nums[i];
            if(i > 0 && first == nums[i-1]){
                continue;
            }
            long threeSum = target - first;
            // 遍历第二个
            for(int j = i+1; j < nums.length - 2; j ++){
                int second = nums[j];
                if(j > i+ 1 && second == nums[j-1]){
                    continue;
                }
                long twoSum = threeSum - second;
                // 双指针确定最后两个
                int l = j+1, r = nums.length - 1;
                while(l < r){
                    if(nums[l] + nums[r] == twoSum){
                        // 存在确定值
                        list.add(List.of(first,second,nums[l],nums[r]));
                        l ++;
                        r --;
                        while(l < r && nums[l] == nums[l-1]){
                            l++;
                        }
                        while(l < r && nums[r] == nums[r+1]){
                            r--;
                        }
                    }else if(nums[l] + nums[r] > twoSum){
                        r --;
                    }else{
                        l ++;
                    }
                }
            }
        }
        return list;
    }

}