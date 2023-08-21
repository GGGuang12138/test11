package leetcode.threeSumClosest;

import java.util.Arrays;

/**
 * @author Alan
 * @Description
 * @date 2023.08.21 22:39
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int curr = nums[i];
            int l = i + 1,r = nums.length-1;
            int currSum = 0;
            while(l < r){
                currSum = curr + nums[l] + nums[r];
                if(currSum == target){
                    return currSum;
                }
                if(currSum > target){
                    // 达到更小的差
                    if(currSum - target < minDiff){
                        minDiff = currSum - target;
                        ans = currSum;
                    }
                    r --;
                }else{
                    // 达到更小的差
                    if(target - currSum < minDiff){
                        minDiff = target - currSum;
                        ans = currSum;
                    }
                    l ++;
                }
            }
        }
        return ans;
    }
}
