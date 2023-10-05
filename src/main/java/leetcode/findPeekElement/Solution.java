package leetcode.findPeekElement;

/**
 * @author Alan
 * @Description
 * @date 2023.10.05 21:24
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int pre = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i ++){
            int next = nums[i];
            int target = nums[i-1];
            if (target > pre && target > next){
                return i - 1;
            }
            pre = target;
        }
        if(nums[nums.length - 1] > pre){
            return nums.length - 1;
        }
        return -1;
    }
}
