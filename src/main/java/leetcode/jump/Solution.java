package leetcode.jump;

/**
 * @author Alan
 * @Description
 * @date 2023.12.27 23:28
 */
public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        // 不用遍历到最后一格
        for(int i = 0; i < nums.length - 1; i ++){
            // 判断下一次能抵达的最后一格
            maxPosition = Math.max(maxPosition,nums[i]+i);
            // 已经抵达上一次能到达的最后一格了
            if(i == end){
                step ++;
                end = maxPosition;
            }
        }
        return step;
    }
}
