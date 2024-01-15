package leetcode.sortedSquares;

/**
 * @author Alan
 * @Description
 * @date 2024.01.09 22:30
 */
class Solution {

    public static void main(String[] args) {
        int[] ints = sortedSquares2(new int[]{-4,-1,0,3,10});
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] sortedSquares2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int leftR = 0, rightR = 0;
        while(right >= 0){
            leftR = nums[left]*nums[left];
            rightR = nums[right]*nums[right];
            if(leftR >= rightR){
                nums[left] = nums[right];
                nums[right] = leftR;
            }else{
                nums[right] = rightR;
            }
            right--;
        }
        return nums;
    }
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