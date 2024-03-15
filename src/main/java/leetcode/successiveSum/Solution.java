package leetcode.successiveSum;

import java.util.Scanner;

/**
 * @author Alan
 * @Description
 * @date 2024.03.14 22:52
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        System.out.println(target+"="+target);
        int right = (target + 1) / 2;
        int left = right - 1;
        int sum = left + right;
        int count = 1;
        while(left > 0){
            if (sum == target){
                // 打印
                print(target,left,right);
                count ++;
                // 移动右指针
                sum -= right;
                right--;
                // 移动左指针
                left--;
                sum += left;
            } else if (sum > target){
                sum -= right;
                right--;
            }else {
                left--;
                sum += left;
            }
        }
        System.out.println("Result:"+count);
    }

    public static void print(int target,int left,int right){
        StringBuilder sb = new StringBuilder();
        for(int i = left; i <= right; i++){
            sb.append(i).append("+");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(target+"="+sb);
    }
}
