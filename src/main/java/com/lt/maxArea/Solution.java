package com.lt.maxArea;

/**
 * @author Alan
 * @Description
 * @date 2023.08.15 23:28
 */
public class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while(l < r){
            if(height[l] > height[r]){
                // 左高，取右
                max = Math.max(max,(r-l) * height[r]);
                r --;
            }else{
                max = Math.max(max,(r-l) * height[l]);
                l ++;
            }
        }
        return max;
    }
}
