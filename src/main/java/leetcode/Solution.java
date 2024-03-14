package leetcode;

import java.util.Scanner;

/**
 * @author Alan
 * @Description
 * @date 2024.03.11 23:39
 */
public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.next();
        System.out.println(line);
        String[] arr = line.split(", ");
        // 特殊情况
        if(arr.length == 1 || arr.length == 2){
            System.out.println(1);
            return;
        }
        // 转成nums
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        // 遍历nums进行统计
        int sum = 0;
        for(int i = 1; i < nums.length-1; i++){
            if(i == 1 && nums[0] > nums[1]){
                sum++;
                continue;
            }
            if(i == nums.length - 2 && nums[nums.length-2] < nums[nums.length-1]){
                sum++;
                break;
            }
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                sum++;
            }
        }
        System.out.print(sum);
    }
}
