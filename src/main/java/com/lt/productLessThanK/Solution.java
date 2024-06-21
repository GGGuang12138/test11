package com.lt.productLessThanK;

/**
 * @author Alan
 * @Description
 * @date 2023.08.20 18:43
 */
public class Solution {

    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0;
        int product = 1;
        int res = 0;
        while(r < nums.length){
            product *= nums[r];
            // 不满足条件了移动左指针
            while(product >= k){
                product /= nums[l];
                l ++;
            }
            res += r - l + 1;
            r ++;
        }
        return res;
    }
}
