package leetcode.countSubstrings;

import java.util.Arrays;

/**
 647. 回文子串
 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 回文字符串 是正着读和倒过来读一样的字符串。
 子字符串 是字符串中的由连续字符组成的一个序列。
 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

 示例 1：
 输入：s = "abc"
 输出：3
 解释：三个回文子串: "a", "b", "c"
 示例 2：

 输入：s = "aaa"
 输出：6
 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

 * @author Alan
 * @Description
 * @date 2024.02.21 19:58
 */
public class Solution {
    // dp[i][j] 表示从i到j是否是回文串
    // dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    // 1、定义dp数组 dp[i][j] 表示从i到j是否是回文串
    // 2、递推方程 头尾相等，剩下的也是回文串 dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
    // 3、初始化
    // 4、遍历顺序。因为dp[i][j]要用到dp[i+1][j-1]，所以需要 先后到前 遍历i，再遍历 从前到后 遍历j
    public static int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for (int i = len; i >= 0; i --) {
            for (int j = i; j < len; j++) {
                if (i == j || (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1]))) {
                    System.out.println(s.substring(i,j+1));
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
