package leetcode;

/**
 * @author: Alan
 * @since: 2023/3/15 14:30
 */
public class Prime {

    /**
     * 解决一
     * 遍历每个数检查是否满足质数条件
     *
     * @param n
     * @return
     */
    public static int solve(int n) {
        for (int i = n - 1; i >= 1; i--) {
            if (check(i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean check(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 解决二
     *
     * @param n
     * @return
     */
    public static int solve2(int n) {
        if (n == 2) {
            return -1;
        }
        for (int i = n - 1; i >= 1; i--) {
            // 除以 n/2 以内的数
            boolean flag = true;
            for (int j = i / 2; j > 1; j--) {
                // 能够整除
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solve2(2));
    }

    public static void dfs(String s, int cnt, int[] vis, int pre) {
        if (s.length() == cnt) {
            System.out.println(s);
            return;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (vis[i - 'a'] == 1 || (pre != -1 && pre < i)) continue;
            vis[i - 'a'] = 1;
            dfs(s + (char) i, cnt, vis, i);
            vis[i - 'a'] = 0;
        }
    }

    public static void solve2() {
        int[] vis = new int[26];
        for (int i = 0; i < 26; i++) {
            vis[i] = 0;
        }
        for (int i = 1; i <= 26; i++) {
            dfs("", i, vis, -1);
        }
    }

}
