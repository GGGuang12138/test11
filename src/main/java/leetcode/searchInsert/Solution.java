package leetcode.searchInsert;

/**
 * 确定区间后，需要始终坚持循环不变量
 * @author Alan
 * @Description
 * @date 2024.05.23 17:11
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return right+1;
    }
}
