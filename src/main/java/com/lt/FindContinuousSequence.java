package com.lt;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * @author Alan
 * @Description
 * @date 2023.05.12 20:38
 */
public class FindContinuousSequence {

    public static void main(String[] args) {

        int[][] continuousSequence = findContinuousSequence(9);
    }

    

    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        for(int i = 1; i < target; i ++){
            int sum = (left + right) * (right - left + 1) / 2;
            if(sum == target){
                int[] curr = new int[right-left+1];
                for(int offset = 0; i < curr.length; i++){
                    curr[offset] = left + offset;
                }
                res.add(curr);
                left ++;
            }else if(sum < target){
                right ++;
            }else{
                left ++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
