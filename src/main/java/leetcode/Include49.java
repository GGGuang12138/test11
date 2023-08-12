package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Alan
 * @since: 2023/3/13 21:39
 */
public class Include49 {

    private static int length;
    private static int[][] dp;
    private static Integer[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String numStr = Integer.toString(num);
        length = numStr.length();
        arr = Arrays.stream(numStr.split("")).map(Integer::parseInt).toArray(Integer[]::new);
        dp = new int[length][10];
        System.out.println(num + 1 - dfs(0, true, 0));
    }

    /**
     * 数位搜索, 统计"不包含49"的数
     *
     * @param level
     * @param limit
     */
    public static int dfs(int level, boolean limit, int pre) {
        // 终止条件
        if (level == length) {
            return 1;
        }
        // 存在缓存
        if (!limit && dp[level][pre] != 0) {
            return dp[level][pre];
        }
        // 当层层处理
        int count = 0;
        int max = limit ? arr[level] : 9;
        for (int i = 0; i <= max; i++) {
            if (i == 9 && pre == 4) {
                continue;
            }
            // 当前层存在限制 并且当前已取得最大值，则下一层也需要限制
            boolean nextLimit = limit && i == max;
            count += dfs(level + 1, nextLimit, i);
        }
        // 放入缓存
        if (!limit) {
            dp[level][pre] = count;
        }
        return count;


    }
}
