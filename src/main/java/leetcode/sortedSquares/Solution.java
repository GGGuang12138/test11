package leetcode.sortedSquares;

/**
 * @author Alan
 * @Description
 * @date 2024.01.09 22:30
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length-1;
        int index = nums.length - 1;
        while(l <= r){
            // 可以换成 nums[l] + nums[r] < 0 。相加为负数说明负的绝对值大
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[index] = (int)Math.pow(nums[l],2);
                l++;
            }else{
                res[index] = (int)Math.pow(nums[r],2);
                r--;
            }
            index --;
        }
        return res;
    }
}