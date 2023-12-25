package leetcode.canJump;

/**
 * @author Alan
 * @Description
 * @date 2023.12.25 23:25
 */
public class Solution {

    public boolean canJump(int[] nums) {
        return canJumpHelper(nums,0);
    }

    public boolean canJumpHelper(int[] nums,int index){
        if(index >= nums.length - 1){
            return true;
        }
        for(int i = nums[index]; i > 0; i --){
            if(canJumpHelper(nums,index+i)){
                return true;
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {
        int able = 0;
        for(int i = 0; i < nums.length; i ++){
            // 判断当前位置能否抵达
            if(i > able){
                return false;
            }
            // 更新能达到的位置
            able = Math.max(able,i+nums[i]);
        }
        return true;
    }

}
