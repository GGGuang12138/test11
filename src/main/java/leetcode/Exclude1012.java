package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author: Alan
 * @since: 2023/3/12 22:18
 */
public class Exclude1012 {

    /**
     * 遍历
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int leftNum = in.nextInt();
        int rightNum = in.nextInt();
        System.out.print(digitSearch(rightNum) - digitSearch(leftNum - 1));

    }

    /**
     * 小于num的数中，不包含101的个数
     *
     * @param num
     * @return
     */
    private static int digitSearch(int num) {
        List<Integer> list = Arrays.stream(Integer.toBinaryString(num).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // 保存已经遍历的位置
        int[][][] dp = new int[list.size()][2][2];
        return dfs(0, true, 0, 0, dp, list);
    }

    private static int dfs(int level, boolean limit, int pre, int prepre, int[][][] dp, List<Integer> list) {
        if (level == dp.length) {
            return 1;
        }
        // 存在缓存
        if (!limit && dp[level][pre][prepre] != 0) {
            return dp[level][pre][prepre];
        }
        // 当前level可选最大值
        int max = limit ? list.get(level) : 1;
        int count = 0;
        // 当前level选择选择不同值的情况
        for (int i = 0; i <= max; i++) {
            // 包含了101
            if (i == 1 && pre == 0 && prepre == 1) {
                continue;
            }
            // 当前level存在限制位,且已达到限制位，下一个level则也需要限制
            boolean nextLimit = limit && i == max;
            count += dfs(level + 1, limit && i == max, i, pre, dp, list);
        }
        if (!limit) {
            dp[level][pre][prepre] = count;
        }
        return count;

    }

}
