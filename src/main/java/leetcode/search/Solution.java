package leetcode.search;

/**
 * @author Alan
 * @Description
 * @date 2024.01.07 22:28
 */
class Solution {
    // 模拟每次锁定一个左闭右闭的区间，mid+1/-1都可
    // 模拟每次锁定左闭右开，只能l=mid+1，不能 r = mid-1，因为右为开，会出现漏检查
    // 模拟怎样的区间会决定l<=r/l<r
    // 寻找左侧边界的搜索，和target相等时，右指针继续移动
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] > target){
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        if(nums.length == l || nums[l] != target){
            return -1;
        }
        return l;
    }
}