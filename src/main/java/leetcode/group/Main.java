package leetcode.group;

import java.util.Scanner;

/**
 * @author Alan
 * @Description
 * @date 2024.04.03 11:42
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        // 读取数据到int[]
        String[] split = scanner.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        // 遍历每个元素作为中点时，分别统计左右两边大于当前元素的个数
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int leftGtCount = 0;
            int leftLtCount = 0;
            for (int l = 0; l < i; l ++){
                if (nums[l] > nums[i]){
                    leftGtCount++;
                }else if (nums[l] < nums[i]){
                    leftLtCount++;
                }
            }
            int rightGtCount = 0;
            int rightLtCount = 0;
            for (int r = i + 1; r < nums.length; r++){
                if (nums[r] > nums[i]){
                    rightGtCount++;
                }else if (nums[r] < nums[i]){
                    rightLtCount++;
                }
            }
            count += leftGtCount * rightLtCount + leftLtCount * rightGtCount;
        }

        System.out.println(count);
    }
}
