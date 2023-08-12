package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环问题
 *
 * @author: Alan
 * @since: 2023/3/19 23:10
 */
public class JosephRing {

    public static void main(String[] args) {

    }

    public static int solve(int n, int m) {
        List<Integer> q = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        // 报的数
        int num = 0;
        // 报数人
        int idx = 0;
        while (q.size() > 1) {
            // 循环报数
            num = (num + 1) % m;
            // 报数为0，要退出
            if (num == 0) {
                q.remove(idx);
                idx -= 1;
            }
            // 报数人循环
            idx = (idx + 1) % (q.size());
        }
        return q.get(0);
    }

}
